package co.com.mini.ecommerce.Common.Errors;

import java.util.Map;

public interface ApplicationErrorSpec {
    String errorCode();

    HttpStatusCode httpstatuscode();

    String getMessage();

    default Map<String, Object> metadata() {return Map.of();}
}
