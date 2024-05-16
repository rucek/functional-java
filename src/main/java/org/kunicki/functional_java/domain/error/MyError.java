package org.kunicki.functional_java.domain.error;

public sealed interface MyError permits MyError.DomainError, ExternalError {

    record DomainError(String message) implements MyError {
    }
}
