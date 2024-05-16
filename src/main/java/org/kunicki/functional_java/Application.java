package org.kunicki.functional_java;

import org.kunicki.functional_java.api.Api;
import org.kunicki.functional_java.domain.Service;

// @SpringBootApplication
public class Application {

    private void start() {
        // load config
        // create database connection pool

        // create repository
        final var service = new Service(/* repository */);
        final var api = new Api(service);

        // HTTP server
        // ...
    }

    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        //region Alternative
        new Application().start();
        //endregion
    }
}
