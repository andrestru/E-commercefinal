package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Common.NonEmptyString;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyJsonCodec {

    public static class NonEmptyEncoder extends JsonSerializer<NonEmptyString>{

        @Override
        public void serialize(NonEmptyString nonEmptyString, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(nonEmptyString.getValue());
        }
    }

    public static class NonEmptyDecoder extends JsonDeserializer<NonEmptyString>{

        @Override
        public NonEmptyString deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final String value = jsonParser.getValueAsString();
            return new NonEmptyString(value);
        }
    }

}
