package org.kunicki.functional_java.common;

import java.util.function.Supplier;

public sealed interface Attempt<A> {

    record Success<A>(A value) implements Attempt<A> {
    }

    record Failure<A>(Exception e) implements Attempt<A> {
    }

    static <A> Attempt<A> of(Supplier<A> supplier) {
        try {
            return new Success<>(supplier.get());
        } catch (Exception e) {
            return new Failure<>(e);
        }
    }
}
