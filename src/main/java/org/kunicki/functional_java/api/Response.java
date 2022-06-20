package org.kunicki.functional_java.api;

sealed interface Response<T> {

    record Ok<T>(T value) implements Response<T> {
    }

    record NotFound<T>() implements Response<T> {
    }

    record ServerError(String message) implements Response<String> {
    }

    //region Factory methods
    static <T> Response<T> ok(T value) {
        return new Ok<>(value);
    }

    static <T> Response<T> notFound() {
        return new NotFound<>();
    }

    static Response<String> serverError(String message) {
        return new ServerError(message);
    }
    //endregion
}
