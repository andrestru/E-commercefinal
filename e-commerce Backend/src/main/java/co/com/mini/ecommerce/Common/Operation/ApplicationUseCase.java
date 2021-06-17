package co.com.mini.ecommerce.Common.Operation;

public interface ApplicationUseCase <IN extends ApplicationRequest, OUT extends ApplicationResponse>{
    OUT execute(IN request);
}
