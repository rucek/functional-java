package org.kunicki.functional_java.api;

import org.kunicki.functional_java.common.Or;
import org.kunicki.functional_java.domain.Service;
import org.kunicki.functional_java.domain.User;
import org.kunicki.functional_java.domain.error.Error;
import org.kunicki.functional_java.domain.error.ExternalError;

import java.util.Optional;

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

    public Response<?> betterFindUserById(Long id) {
        final var user = service.betterFindUserById(id);
        return switch (user) {
            case Or.Right<?, Optional<User>> r -> r.value().map(Response::ok).orElse(Response.notFound());
            case Or.Left<Error, ?> l -> switch (l.value()) {
                case Error.DomainError e && e.message().startsWith("E") ->
                    Response.serverError("Specific domain error: " + e.message());
                case Error.DomainError e -> Response.serverError("Domain error: " + e.message());
                case ExternalError e -> Response.serverError("External error: " + e.message());
            };
        };
    }
}
