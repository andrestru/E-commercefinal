package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
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
public class CcNumberJsonCodec {

    public static class CcNumberEncoder extends JsonSerializer<CCNumber> {

        @Override
        public void serialize(CCNumber ccNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(ccNumber.getIdentification());
        }
    }

    public static class CcNumberDecoder extends JsonDeserializer<CCNumber> {

        @Override
        public CCNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int number = jsonParser.getIntValue();
            return new CCNumber(number);
        }
    }

}
