package com.rifkyaziz.vertx.handler;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class MainHandler {

    public static void homeHandler(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();

        String exampleResponse = "{ \"message\": \"Hello World\"}";
        response.putHeader("content-type", "application/json")
                .end(exampleResponse);
    }
}
