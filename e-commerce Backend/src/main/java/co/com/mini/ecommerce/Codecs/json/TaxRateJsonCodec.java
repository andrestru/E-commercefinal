package co.com.mini.ecommerce.Codecs.json;

import co.com.mini.ecommerce.Application.Domain.CheckTaxRate;
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
public class TaxRateJsonCodec {

    public static class TaxRateEncoder extends JsonSerializer<CheckTaxRate>{

        @Override
        public void serialize(CheckTaxRate checkTaxRate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(checkTaxRate.getValue());
        }
    }

    public static class TaxRateDecoder extends JsonDeserializer<CheckTaxRate>{

        @Override
        public CheckTaxRate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final double taxrate = jsonParser.getDoubleValue();
            return new CheckTaxRate(taxrate);
        }
    }

}
