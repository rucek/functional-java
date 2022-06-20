package org.kunicki.functional_java.domain.error;

public sealed interface Error permits Error.DomainError, ExternalError {

    record DomainError(String message) implements Error {
    }
}
