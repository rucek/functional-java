package org.kunicki.functional_java.common;

public sealed interface Or<L, R> {

    record Left<L, R>(L value) implements Or<L, R> {
    }

    record Right<L, R>(R value) implements Or<L, R> {
    }

    //region Factory methods
    static <L, R> Or<L, R> left(L value) {
        return new Left<>(value);
    }

    static <L, B> Or<L, B> right(B value) {
        return new Right<>(value);
    }
    //endregion
}
