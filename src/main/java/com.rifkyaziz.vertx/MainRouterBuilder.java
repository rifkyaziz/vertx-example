package com.rifkyaziz.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

class MainRouterBuilder {

    private Vertx vertx;

    MainRouterBuilder setVertx(Vertx vertx) {
        this.vertx = vertx;
        return this;
    }

    Router build() {
        Router router = Router.router(this.vertx);

        router.route("/").handler( routingContext -> {
            HttpServerResponse response = routingContext.response();

            String exampleResponse = "{ \"message\": \"Hello World\"}";
            response.putHeader("content-type", "application/json")
                    .end(exampleResponse);
        });

        return router;
    }
}
