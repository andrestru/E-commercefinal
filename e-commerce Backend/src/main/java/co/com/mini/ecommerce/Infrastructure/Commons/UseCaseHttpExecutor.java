package co.com.mini.ecommerce.Infrastructure.Commons;


import co.com.mini.ecommerce.Common.Errors.ApplicationError;
import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UseCaseHttpExecutor {

    public <IN extends ApplicationRequest, OUT extends ApplicationResponse>ResponseEntity execute(
            ApplicationUseCase<IN,OUT> useCase, IN ApplicationRequest
    ) {
        try {
            OUT response = useCase.execute(ApplicationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (ApplicationError applicationError) {
            int httpcode = applicationError.httpstatuscode().getCode();
            Map<String, Object> body = Map.of(
                    "Message", applicationError.getMessage(),
                    "ErrorCode", applicationError.errorCode(),
                    "Metadata", applicationError.metadata()
            );
            return ResponseEntity.status(httpcode).body(body);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
