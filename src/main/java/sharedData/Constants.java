package sharedData;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Constants {

    public static final ThreadLocal<Response> RESPONSE = new ThreadLocal<Response>();
    public static final ThreadLocal<ValidatableResponse> VALIDATABLE_RESPONSE = new ThreadLocal<ValidatableResponse>();

}