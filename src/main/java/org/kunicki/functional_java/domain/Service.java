package org.kunicki.functional_java.domain;

import java.util.Optional;

public class Service {

    //region Pure functions

    //region Definition
    /*
     Q: What makes a function pure?
        * the output only depends on the inputs
        * no side effects
     */
    //endregion

    long doStuff(final long n, final Data data) {
        /*
        P: mutates the argument
         */
        data.setValue("devoxxpl");

        /*
        P: interacts with I/O
         */
        System.out.println(n);

        /*
        P: depends on something external
        P: the if statement does not have a value
         */
        if (System.currentTimeMillis() % 2 == 0) {
            return n;
        } else {
            return n + 1;
        }
    }

    //region Tips
        /*
        T: Use (immutable) values wherever possible
         */
        /*
        T: Control the side effects
        */
        /*
        T: Prefer immutability as a rule of thumb
        */
    //endregion

    //endregion

    //region Error handling
    public Optional<User> findUserById(Long id) {
        return Optional.of(new User(42L, "Jacek"));
    }

    //region Tips
        /*
        T: Return expected errors as plain values
         */
        /*
        T: Keep a catch-all error handler for truly unexpected errors
         */
    //endregion
    //endregion
}
