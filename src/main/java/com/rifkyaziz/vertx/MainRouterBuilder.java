package com.rifkyaziz.vertx;

import com.rifkyaziz.vertx.handler.MainHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

class MainRouterBuilder {

    private Vertx vertx;

    MainRouterBuilder setVertx(Vertx vertx) {
        this.vertx = vertx;
        return this;
    }

    Router build() {
        Router router = Router.router(this.vertx);

        router.route("/").handler(MainHandler::homeHandler);

        return router;
    }
}
