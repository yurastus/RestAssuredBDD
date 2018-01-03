package tools;

import dataModels.IModel;
import lombok.extern.log4j.Log4j;
import static io.restassured.RestAssured.when;
import static sharedData.Constants.RESPONSE;

@Log4j
public class CRUD {

    private CRUD(){}

    public static void httpGet(String url){
        RESPONSE.set(when().get(url));
        log.info(RESPONSE.get().getBody().asString());
    }

    public static void httpPost(String url, IModel model){
        RESPONSE.set(when().post(url, model));
        log.info(RESPONSE.get().getBody().asString());
    }


}