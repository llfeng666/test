package com.liquido.utils;

/*
 * Vendored version of
 * https://github.com/jdbi/jdbi/blob/master/core/src/main/java/org/jdbi/v3/core/internal/exceptions/Unchecked.java
 * Copyright (c), Data Geekery GmbH, contact@datageekery.com
 */

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("PMD.AvoidCatchingThrowable")
public class Unchecked {
    private Unchecked() {
        throw new UtilityClassException();
    }

    public static <T> Consumer<T> consumer(final CheckedConsumer<T> checkedConsumer) {
        return (x) -> {
            try {
                checkedConsumer.accept(x);
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    @SuppressWarnings("PMD.DoNotUseThreads")
    public static Runnable runnable(final CheckedRunnable checkedRunnable) {
        return () -> {
            try {
                checkedRunnable.run();
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <T> SneakyCallable<T> callableAdapt(final Callable<T> callable) {
        return () -> {
            try {
                return callable.call();
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <T> SneakyCallable<T> callable(final CheckedCallable<T> checkedCallable) {
        return () -> {
            try {
                return checkedCallable.call();
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <T> Supplier<T> supplier(final CheckedSupplier<T> checkedSupplier) {
        return () -> {
            try {
                return checkedSupplier.get();
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <X, T> Function<X, T> function(final CheckedFunction<X, T> checkedFunction) {
        return x -> {
            try {
                return checkedFunction.apply(x);
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <X, Y, T> BiFunction<X, Y, T> biFunction(
            final CheckedBiFunction<X, Y, T> checkedBiFunction
    ) {
        return (x, y) -> {
            try {
                return checkedBiFunction.apply(x, y);
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <X, Y> BiConsumer<X, Y> biConsumer(
            final CheckedBiConsumer<X, Y> checkedBiConsumer
    ) {
        return (x, y) -> {
            try {
                checkedBiConsumer.accept(x, y);
            } catch (final Throwable t) {
                throw throwAnyway(t);
            }
        };
    }

    public static <X> X futureGet(final Future<X> future, final Duration timeout) {
        return futureGet(future, timeout.toNanos(), TimeUnit.NANOSECONDS);
    }

    public static <X> X futureGet(final Future<X> future, final long timeout, final TimeUnit unit) {
        try {
            return future.get(timeout, unit);
        } catch (final Throwable t) {
            throw throwAnyway(t);
        }
    }

    /**
     * Will <b>always</b> throw an exception, so the caller should also always throw the dummy
     * return value to make sure the control flow remains clear.
     */
    @CheckReturnValue
    @Nonnull
    public static RuntimeException throwAnyway(final Throwable t) {
        if (t instanceof Error) {
            throw (Error) t;
        }

        if (t instanceof RuntimeException) {
            throw (RuntimeException) t;
        }

        if (t instanceof IOException) {
            throw new UncheckedIOException((IOException) t);
        }

        if (t instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }

        if (t instanceof InvocationTargetException || t instanceof ExecutionException) {
            log.trace("Unwrapping execution exception", t);
            throw throwAnyway(t.getCause());
        }

        throw throwEvadingChecks(t);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Throwable> E throwEvadingChecks(final Throwable throwable) throws E {
        throw (E) throwable;
    }

    public interface SneakyCallable<T> extends Callable<T> {
        @Override
        T call(); // no 'throws Exception'
    }

    public interface CheckedRunnable {
        void run() throws Exception;
    }

    @FunctionalInterface
    public interface CheckedBiConsumer<X, Y> {
        void accept(X x, Y y) throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedBiFunction<X, Y, T> {
        T apply(X x, Y y) throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedCallable<T> {
        T call() throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedConsumer<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface CheckedFunction<X, T> {
        T apply(X x) throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedPredicate<X> {
        boolean test(X x) throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedUnaryOperator<X> {
        X apply(X x) throws Throwable;
    }

    @FunctionalInterface
    public interface CheckedSupplier<T> {
        T get() throws Throwable;
    }
}
