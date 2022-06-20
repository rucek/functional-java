package org.kunicki.functional_java.domain.error;

public record ExternalError(String message) implements Error {
}
