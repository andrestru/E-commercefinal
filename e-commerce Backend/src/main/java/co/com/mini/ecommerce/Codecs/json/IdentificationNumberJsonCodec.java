package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Application.Domain.IdentificationNumber;
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
public class IdentificationNumberJsonCodec {

    public static class IdentificationEncoder extends JsonSerializer<IdentificationNumber>{

        @Override
        public void serialize(IdentificationNumber identificationNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(identificationNumber.getIdentification());
        }
    }

    public static class IdentificationDecoder extends JsonDeserializer<IdentificationNumber>{

        @Override
        public IdentificationNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int identification = jsonParser.getIntValue();
            return new IdentificationNumber(identification);
        }
    }

}
