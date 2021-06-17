package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Application.Domain.CheckInventory;
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
public class QuantityInventoryJsonCodec {

    public static class InventoryEncoder extends JsonSerializer<CheckInventory>{

        @Override
        public void serialize(CheckInventory checkInventory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(checkInventory.getValue());
        }
    }

    public static class InventoryDecoder extends JsonDeserializer<CheckInventory>{

        @Override
        public CheckInventory deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int inventory = jsonParser.getIntValue();
            return new CheckInventory(inventory);
        }
    }

}
