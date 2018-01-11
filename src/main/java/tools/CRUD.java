package tools;

import dataModels.IModel;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import static io.restassured.RestAssured.*;
import static sharedData.Constants.REQUEST_SPECIFICATION;
import static sharedData.Constants.RESPONSE;

@Log4j
public class CRUD {

    private CRUD(){}


    public static void httpPost(IModel model){
        Response response = REQUEST_SPECIFICATION.get().body(model).when().post();
        RESPONSE.set(response);

        log.info(response.getBody().asString());
    }


    public static void httpPut(String id, IModel model){
        Response response = REQUEST_SPECIFICATION.get().body(model).when().put(id);
        RESPONSE.set(response);

        log.info(response.getBody().asString());
    }


    public static void httpDelete(String userId){
        RESPONSE.set(when().delete(userId));

        log.info(RESPONSE.get().getBody().asString());
    }


    public static void httpGet(){
        httpGet("");
    }

    public static void httpGet(int params){
        httpGet(params + "");
    }

    private static void httpGet(String params){
        RESPONSE.set(when().get(params));

        log.info(RESPONSE.get().getBody().asString());
    }

}