package tools;

import dataModels.BaseModel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import static io.restassured.RestAssured.*;
import static sharedData.Constants.*;

@Slf4j
public class CRUD {

    private CRUD(){}


    public static void httpPost(BaseModel model){
        Response response = REQUEST_SPECIFICATION.get().body(model).when().post();
        RESPONSE.set(response);

        log.info(response.getBody().asString());
    }


    public static void httpPut(String id, BaseModel model){
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