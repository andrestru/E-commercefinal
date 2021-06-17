package co.com.mini.ecommerce.Application.Errors;

import co.com.mini.ecommerce.Common.Errors.ApplicationError;
import co.com.mini.ecommerce.Common.Errors.HttpStatusCode;

public class InputDataError extends ApplicationError {

    private final String message;

    public InputDataError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String errorCode() {
        return "INPUT_DATA_ERROR";
    }

    @Override
    public HttpStatusCode httpstatuscode() {
        return httpstatuscode().BAD_REQUEST;
    }
}
