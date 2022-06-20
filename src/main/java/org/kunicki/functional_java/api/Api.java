package org.kunicki.functional_java.api;

import org.kunicki.functional_java.domain.Service;

public class Api {

    private final Service service;

    public Api(Service service) {
        this.service = service;
    }

    public Response<?> findUserById(Long id) {
        final var user = service.findUserById(id);
        return user
            .map(Response::ok)
            .orElse(Response.notFound());

        //region Questions
            /*
            Q: Can you tell whether the service can respond with expected/business/domain errors?
             */
            /*
            Q: What happens to those errors?
             */
            /*
            Q: Are GOTO statements good?
             */
            /*
            Q: What if we represented expected errors as plain values?
             */
        //endregion
    }
}
