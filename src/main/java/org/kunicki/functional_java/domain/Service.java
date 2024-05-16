package org.kunicki.functional_java.domain;

import org.kunicki.functional_java.common.Attempt;
import org.kunicki.functional_java.common.Or;
import org.kunicki.functional_java.domain.error.MyError;

public class Service {

    //region Pure functions and immutable values

    //region Definition
        /*
         * idempotency - same state after multiple calls
         */
        /*
         * referential transparency (RT) - can replace calls with results
         */
        /*
         * idempotent ⊆ RT
         */
        /*
         * what makes a function pure?
            * the output only depends on the inputs
            * no (unmanaged) side effects
         */
    //endregion

    // region Example
    long doStuff(final long n, final Data data) {
        /*
        P: mutates the argument (shared state)

        P: does Data actually represent some fixed data?
         */
        data.setValue("GeeCON 2024");

        /*
        P: interacts with I/O - side effect
         */
        System.out.println(n);

        /*
        P: depends on something external

        P: breaks idempotency / referential transparency
         */
        if (System.currentTimeMillis() % 2 == 0) {
            return n;
        } else {
            return n + 1;
        }
    }
    //endregion

    //endregion

    //region Error handling
    public User findUserById(Long id) {
        return new User(42L, "Jacek");
    }

    public Attempt<User> betterFindUserById(Long id) {
        return Attempt.of(() -> findUserById(id));
    }

    public Or<MyError, User> evenBetterFindUserById(Long id) {
        return Or.left(new MyError.DomainError("Boom!"));
    }
    //endregion
}
