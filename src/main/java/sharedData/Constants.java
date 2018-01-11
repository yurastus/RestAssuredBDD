package sharedData;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Constants {

    public static final ThreadLocal<Response> RESPONSE = new ThreadLocal<Response>();
    public static final ThreadLocal<ValidatableResponse> VALIDATABLE_RESPONSE = new ThreadLocal<ValidatableResponse>();
    public static final ThreadLocal<RequestSpecification> REQUEST_SPECIFICATION = new ThreadLocal<RequestSpecification>();

}