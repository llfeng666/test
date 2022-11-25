package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Bs2BoletoClientInfo {
    @JsonProperty("clienteId")
    String clientId;
    public Optional<String> getClientId() {
        return Optional.ofNullable(clientId);
    }

//    @JsonProperty("telefone")
//    @JsonSerialize(contentUsing = BoletoPhoneNumberSerializer.class)
//    @JsonDeserialize(using = BoletoPhoneNumberDeserializer.class)
//    PhoneNumber phoneNumber;
//    public Optional<PhoneNumber> getPhoneNumber() {
//        return Optional.ofNullable(phoneNumber);
//    }
//
//    @JsonProperty("email")
//    String email;
//    public Optional<String> getEmail() {
//        return Optional.ofNullable(email);
//    }
//
//    @JsonProperty("tipo")
//    Bs2DocumentType documentType;
//    public Optional<Bs2DocumentType> getDocumentType() {
//        return Optional.ofNullable(documentType);
//    }
//
//    @JsonProperty("documento")
//    String document;
//    public Optional<String> getDocument() {
//        return Optional.ofNullable(document);
//    }
//
//    @JsonProperty("nome")
//    String name;
//    public Optional<String> getName() {
//        return Optional.ofNullable(name);
//    }
//
//    @JsonProperty("endereco")
//    Bs2BoletoAddress address;
//    public Optional<Bs2BoletoAddress> getAddress() {
//        return Optional.ofNullable(address);
//    }
//
//    private static class BoletoPhoneNumberSerializer extends JsonSerializer<PhoneNumber> {
//        @Override
//        public void serialize(final PhoneNumber value,
//                              final JsonGenerator gen,
//                              final SerializerProvider serializers
//        ) throws IOException {
//            gen.writeObject(value.getNationalNumber());
//        }
//    }
//
//    private static class BoletoPhoneNumberDeserializer extends JsonDeserializer<PhoneNumber> {
//        @Override
//        public PhoneNumber deserialize(
//                final JsonParser p,
//                final DeserializationContext ctxt) throws IOException {
//            try {
//                final var phoneNumber = p.readValueAs(String.class);
//                if (!TextUtils.isBlank(phoneNumber)) {
//                    return LqPhoneUtils.parse(
//                            LqPhoneUtils.PLUS_SIGN
//                            + LqPhoneUtils
//                                    .getCountryCallingCodeForCountryCode(CountryCode.BR)
//                            + phoneNumber);
//                } else {
//                    return null;
//                }
//            } catch (Exception e) {
//                throw new JsonParseException(p, "Invalid Phone Number", e);
//            }
//        }
//    }

}
