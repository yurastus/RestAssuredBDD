package dataModels;

import tools.JacksonUtils;

public class BaseModel {

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}






