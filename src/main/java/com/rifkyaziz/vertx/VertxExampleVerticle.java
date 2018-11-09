package com.rifkyaziz.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class VertxExampleVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) {
        Router router = new MainRouterBuilder().setVertx(vertx).build();

        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(config().getInteger("http.port", 8080), result -> {
                if (result.succeeded()) {
                    future.complete();
                } else {
                    future.fail(result.cause());
                }
            });
    }
}
