package com.it_academy.rest_api.utils;

import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;
import java.util.Map;


import static io.restassured.RestAssured.given;

public final class getRequestUtils {

    private getRequestUtils(){

    }

    public static ResponseBody makeGetRequestAndGetResponseBody(String endpoint, Map<String, Object> headers,
                                                                Map<String, Object> params){
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }

}
