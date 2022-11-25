package com.liquido.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import com.liquido.exceptions.InternalServerException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LqDateUtils {

    // ZoneIds that are used commonly in our code
    public static final ZoneId BRAZIL_TIME = ZoneId.of("America/Sao_Paulo");
    public static final ZoneId BEIJING_TIME = ZoneId.of("Asia/Shanghai");
    public static final ZoneId CALIFORNIA_TIME = ZoneId.of("America/Los_Angeles");
    public static final ZoneId MEXICO_TIME = ZoneId.of("America/Mexico_City");
    public static final ZoneId COLOMBIA_TIME = ZoneId.of("America/Bogota");
    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

    // Special
    private static final String GMT_0_TIME_ZONE = "GMT+00:00";

    // "2021-04-16 19:20:29 UTC"
    private static final String FORMAT_WITH_ZONE = "yyyy'-'MM'-'dd' 'HH':'mm':'ss' 'z";
    private static final String FORMAT_WITH_DATE_ONLY = "yyyy'-'MM'-'dd";
    private static final long ONE_HOUR_IN_MILLIS = 60 * 60 * 1000;

    private final Set<String> supportedTimeZones;

    private final Clock clock;

    @Autowired
    LqDateUtils(final Clock clock) {
        this.clock = clock;
        this.supportedTimeZones = Set.of(
                "GMT-07:00", // California
                "GMT-03:00", // Sao Paolo
                "GMT+00:00", // UTC
                "GMT+08:00",  // Beijing
                "GMT-05:00"   //  MEXICO
        );
    }

    /**
     * Returns a new formatter instance to avoid synchronization problem
     */
    private SimpleDateFormat getFormatter(final String timeZoneName) {
        final var res = new SimpleDateFormat(FORMAT_WITH_ZONE, Locale.ENGLISH);
        if (!supportedTimeZones.contains(timeZoneName)) {
            log.warn(
                    "Unsupported time zone name: {}. Returning formatter with GMT0 time zone",
                    timeZoneName
            );
            return getFormatter(GMT_0_TIME_ZONE);
        }
        // NOTE: if timeZoneName is malformed, this would return GMT0
        final var timezone = TimeZone.getTimeZone(timeZoneName);
        res.setTimeZone(timezone);
        return res;
    }

    private SimpleDateFormat getFormatter(final ZoneId timeZone) {
        final var res = new SimpleDateFormat(FORMAT_WITH_ZONE, Locale.ENGLISH);
        res.setTimeZone(TimeZone.getTimeZone(toZoneOffset(timeZone)));
        return res;
    }

    private ZoneOffset toZoneOffset(final ZoneId timeZone) {
        // Using clock.instant() to figure out the ZoneOffset for the current time
        return timeZone.getRules().getOffset(clock.instant());
    }

    public long getCurrentUnixTimeInSeconds() {
        return clock.millis() / DateUtils.MILLIS_PER_SECOND;
    }

    public String getCurrentDateString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.ENGLISH);
        return sdf.format(Date.from(clock.instant()));
    }

    public String getTomorrowDateString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.ENGLISH);
        return sdf.format(Date.from(clock.instant().plus(1, ChronoUnit.DAYS)));
    }

    public String getPastDateString(final int offset) {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.ENGLISH);
        return sdf.format(Date.from(clock.instant().minus(offset, ChronoUnit.DAYS)));
    }

    public String getYesterdayDateString() {
        return getPastDateString(1);
    }

    public long getPastUnixTimeInSecondsWithDiffStr(final String hoursDiffStr) {
        return getPastUnixTimeInSeconds(Integer.parseInt(hoursDiffStr));
    }

    public long getPastUnixTimeInSeconds(final long hoursDiff) {
        final long timeDiffInMillis = hoursDiff * ONE_HOUR_IN_MILLIS;
        return (clock.millis() - timeDiffInMillis) / DateUtils.MILLIS_PER_SECOND;
    }

    public String getUtcStrFromUnixTime(final long unixTimeInSeconds) {
        return getFormatter(GMT_0_TIME_ZONE).format(
                unixTimeInSeconds * DateUtils.MILLIS_PER_SECOND);
    }

    /**
     * @deprecated because it uses custom timezone name. Unless we are dealing with legacy code,
     * we should be using java.time.ZoneId. Use {@link #formatUnixTimeWithZoneId(long, ZoneId)}
     * instead
     */
    @Deprecated
    public String formatUnixTime(final long unixTime, final String timeZoneName) {
        return getFormatter(timeZoneName)
                .format(unixTime * DateUtils.MILLIS_PER_SECOND);
    }

    /**
     * @deprecated use {@link #formatInstantWithZoneId(Instant, ZoneId)} instead
     */
    @Deprecated
    public String formatUnixTimeWithZoneId(final long unixTimeInSeconds, final ZoneId timeZone) {
        return getFormatter(timeZone).format(unixTimeInSeconds * DateUtils.MILLIS_PER_SECOND);
    }

    public String formatInstantWithZoneId(final Instant t, final ZoneId timeZone) {
        return getFormatter(timeZone).format(Date.from(t));
    }

    //
    // This is used to parse vendor/Unipagos's formatted time string to unix time
    // Using org.apache.commons:commons-lang3
    //
    private final String[] supportedUnipagosFormats =
            {
                    "yyyy-MM-dd HH:mm:ss Z",            // 2014-06-30 10:24:53 GMT-05:00
                    "yyyy-MM-dd HH:mm:ss.SSSSSSX",      // 2014-06-30 10:24:53.000123-05
                    "yyyy-MM-dd HH:mm:ss.SSS Z",        // 2014-06-30 10:24:53.000 GMT-05:00
                    "yyyy-MM-dd HH:mm:ss.SSSZ",         // 2014-06-30 10:24:53.000-0500
                    "yyyy-MM-dd HH:mm:ss.SSSSSSXXX",    // 2014-06-30 10:24:53.000123-05:00
            };

    public long str2UnixTimeInSeconds(final String dateInString) {
        try {
            final Date date = DateUtils.parseDate(dateInString, supportedUnipagosFormats);
            return date.getTime() / DateUtils.MILLIS_PER_SECOND;
        } catch (final ParseException e) {
            log.error("Exception on convert time string to unix time", e);
            return 0;
        }
    }

    public String getCurrentTimeUnipagosFormat(final Instant t) {
        final var formatter = new SimpleDateFormat(supportedUnipagosFormats[4], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(GMT_0_TIME_ZONE));
        return formatter.format(t.toEpochMilli());
    }

    public String getDateOnly(final Long unixTimeInSeconds) {
        return new SimpleDateFormat(FORMAT_WITH_DATE_ONLY, Locale.ENGLISH)
                .format(unixTimeInSeconds * DateUtils.MILLIS_PER_SECOND);
    }

    public String getUtcInstantStrFromUnixTime(final long unixTimeInSeconds) {
        return Instant.ofEpochSecond(unixTimeInSeconds).toString();
    }

    public String getCurrentTimeInBs2Format() {
        final var formatter = new SimpleDateFormat(SUPPORTED_BS2_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(BRAZIL_TIME));
        return formatter.format(clock.millis());
    }

    private static final String[] SUPPORTED_BS2_FORMATS = {
            "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX",
            "yyyy-MM-dd'T'HH:mm:ssXXX"
    };

    public String getTimeInBs2Format(final Instant t) {
        final var formatter = new SimpleDateFormat(SUPPORTED_BS2_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(BRAZIL_TIME));
        return formatter.format(t.toEpochMilli());
    }

    public Instant parseBs2FormattedTime(final String t) {
        try {
            final var parsed = DateUtils.parseDate(t, SUPPORTED_BS2_FORMATS);
            return parsed.toInstant();
        } catch (final ParseException e) {
            throw new InternalServerException(
                    String.format("Failed to parse date string in BS2 format: %s", t), e);
        }
    }

    public Instant now() {
        return clock.instant();
    }

    /**
     * Return a clock instant offset in seconds from now.
     */
    public Instant offsetInSecondsFromNow(final int seconds) {
        final Duration offset = Duration.ofSeconds(seconds);
        return Clock.offset(clock, offset).instant();
    }

    private static final String[] SUPPORTED_ARCUS_FORMATS = {
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
    };

    public String getTimeInArcusFormat(final Instant t) {
        final var formatter = new SimpleDateFormat(SUPPORTED_ARCUS_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(GMT_0_TIME_ZONE));
        return formatter.format(t.toEpochMilli());
    }

    private static final String[] SUPPORTED_BANKLY_FORMATS = {
            "yyyy-MM-dd",
    };

    public String getDateInBanklyFormat(final Instant t) {
        final var formatter = new SimpleDateFormat(SUPPORTED_BANKLY_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(BRAZIL_TIME));
        return formatter.format(t.toEpochMilli());
    }

    private static final String[] SUPPORTED_AQUARIUS_FORMATS = {
            "yyyyMMdd-HHmmss-SSS",
            "yyyy-MM-dd HH:mm:ss"
    };

    public String getTimeInAquariusFormat() {
        final var formatter = new SimpleDateFormat(SUPPORTED_AQUARIUS_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(MEXICO_TIME));
        return formatter.format(clock.millis());
    }

    public Instant parseAquariusFormattedTime(final String t) {
        try {
            final var parsed = DateUtils.parseDate(t, SUPPORTED_AQUARIUS_FORMATS);
            return parsed.toInstant();
        } catch (final ParseException e) {
            throw new InternalServerException(
                    String.format("Failed to parse date string in Aquarius format: %s", t), e);
        }
    }

    public Instant parseMexicoFormattedTime(final String t) {
        try {
            final var parsed = DateUtils.parseDate(t, supportedUnipagosFormats);
            return parsed.toInstant();
        } catch (final ParseException e) {
            throw new InternalServerException(
                    String.format("Failed to parse date string in Aquarius format: %s", t), e);
        }
    }

    private static final String[] SUPPORTED_MIT_FORMATS = {
            "yyyyMMdd'T'HHmmssZ",
    };

    public String getTimeInMitFormat() {
        final var formatter = new SimpleDateFormat(SUPPORTED_MIT_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(MEXICO_TIME));
        return formatter.format(clock.millis());
    }

    private static final String[] SUPPORTED_STP_FORMATS = {
            "yyyyMMddHHmmss",
    };

    public String getTimeInStpFormat() {
        final var formatter = new SimpleDateFormat(SUPPORTED_STP_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(MEXICO_TIME));
        return formatter.format(clock.millis());
    }

    private static final String[] SUPPORTED_PAY_CASH_FORMATS = {
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd",
            "yyyy-M-d HH:mm:ss",
            "d/M/yyyy HH:mm:ss"
    };

    public Instant parsePayCashFormattedTime(final String dateTime, final ZoneId zoneId) {
        return parseFormatTimeByZoneId(dateTime, SUPPORTED_PAY_CASH_FORMATS[0], zoneId);
    }

    public String getTimeInPayCashFormat(final Instant instant, final ZoneId zoneId) {
        final var formatter = new SimpleDateFormat(SUPPORTED_PAY_CASH_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(zoneId));
        return formatter.format(instant.toEpochMilli());
    }

    public String getDateInPayCashFormat(final Instant instant, final ZoneId zoneId) {
        final var formatter = new SimpleDateFormat(SUPPORTED_PAY_CASH_FORMATS[1], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(zoneId));
        return formatter.format(instant.toEpochMilli());
    }

    //TODO We will enhance these two method by using LocalDateTime later.
    public String convertPayCashTimeFromCheckMethod(final String dateTime, final ZoneId zoneId) {
        return getTimeInPayCashFormat(
                parseFormatTimeByZoneId(dateTime, SUPPORTED_PAY_CASH_FORMATS[2], zoneId),
                zoneId
        );
    }

    public String convertPayCashTimeFromCallback(final String dateTime, final ZoneId zoneId) {
        return getTimeInPayCashFormat(
                parseFormatTimeByZoneId(dateTime, SUPPORTED_PAY_CASH_FORMATS[3], zoneId),
                zoneId
        );
    }

    private static final String[] SUPPORTED_BANCOLOMBIA_FORMATS = {
            "yyyyMMdd",
    };

    public String getDateInBancolombiaFormat(final Instant t) {
        final var formatter = new SimpleDateFormat(
                SUPPORTED_BANCOLOMBIA_FORMATS[0], Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(COLOMBIA_TIME));
        return formatter.format(t.toEpochMilli());
    }

    public Instant parseFormatTimeByZoneId(
            final String time,
            final String format,
            final ZoneId zone
    ) {
        try {
            final var simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zone));
            final var parse = simpleDateFormat.parse(time);
            return parse.toInstant();
        } catch (final ParseException e) {
            throw new InternalServerException(
                    String.format("Failed to parse time %s, in format: %s, at time zone: %s",
                            time, format, zone), e);
        }
    }
}
