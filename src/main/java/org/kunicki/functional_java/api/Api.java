package org.kunicki.functional_java.api;

import org.kunicki.functional_java.common.Attempt;
import org.kunicki.functional_java.common.Or;
import org.kunicki.functional_java.domain.Service;
import org.kunicki.functional_java.domain.User;
import org.kunicki.functional_java.domain.error.ExternalError;
import org.kunicki.functional_java.domain.error.MyError;

public class Api {

    private final Service service;

    public Api(Service service) {
        this.service = service;
    }

    public Response<String> findUserById(Long id) {
        final var user = service.findUserById(id);
        return Response.ok(user.name());

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
             * unification
             * except for truly exceptional cases
             */
        //endregion
    }

    public Response<String> betterFindUserById(Long id) {
        final var user = service.betterFindUserById(id);

        return switch (user) {
            case Attempt.Success(var u) -> Response.ok(u.name());
            case Attempt.Failure(var e) -> Response.serverError(e.getMessage());
        };
    }

    public Response<String> evenBetterFindUserById(Long id) {
        final var user = service.evenBetterFindUserById(id);

        return switch (user) {
            case Or.Right(User(_, var name)) -> Response.ok(name);
            case Or.Left(MyError.DomainError(var m)) -> Response.serverError(m);
            case Or.Left(ExternalError(var m)) when m.startsWith("DB") -> Response.serverError(m);
            case Or.Left(ExternalError(var m)) -> Response.serverError(m);
        };
    }
}
