package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
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
public class BasePriceJsonCodec {

    public static class BasePriceEncoder extends JsonSerializer<CheckPrice>{

        @Override
        public void serialize(CheckPrice checkPrice, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(checkPrice.getValue());
        }
    }

    public static class BasePriceDecoder extends JsonDeserializer<CheckPrice>{

        @Override
        public CheckPrice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final double price = jsonParser.getDoubleValue();
            return new CheckPrice(price);
        }
    }

}
