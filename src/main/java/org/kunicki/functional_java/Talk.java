package org.kunicki.functional_java;

public class Talk {

    //region Disclaimer
    //  Everything here would probably be counter-intuitive at first
    //endregion

    //region Functional Programming
        /*
         * FP = pure functions + immutable values
         */
        /*
         * immutable values can be safely passed around
         */
        /*
         * pure functions can be memoized
         */
        /*
         * pure functions are thread-safe - can be safely parallelized
         */
        /*
         * pure functions are suitable for property-based testing
         */
        /*
         * "easier to reason about" - buzzword, but it's true
         */
    //endregion

    //region Functional error handling
    //endregion

    //region Algebraic Data Types
        /*
         * types formed by combining other types
         */
        /*
         * record - (cartesian) product
         */
        /*
         * sealed hierarchy - sum (disjoint union, coproduct)
         */
        /*
         * aggregation vs choice
         */
        /*
         * illegal states are unrepresentable
         */
    //endregion

    //region Validation
        /*
         * monads - e.g. Either
            * allow to sequence dependent computations
            * fail fast
         */
        /*
         * applicatives (applicative functors) - e.g. Validation
            * allow to run computations independently
            * accumulate the results
         */
    //endregion

    //region Bonus: framework-less
        /*
         * Over-engineering?
         */
        /*
         * Framework vs libraries
         */
        /*
         * Programming with @Annotations
         */
    //endregion

    //region Takeaways
        /*
         * Try to think in pure functions and immutable values
         */
        /*
         * Avoid exceptions for flow control - errors can be values too
         */
        /*
         * Leverage the power of ADTs and pattern matching
         *
           * https://sml.io/java-21-switch
         */
        /*
         * Monads do not bite, neither do applicatives, functors etc.
         */
        /*
         * There's life beyond @SpringBootApplication
         *
           * https://sml.io/the-case-against-annotations
         */
        /*
         * Read "Functional Programming Simplified" by Alvin Alexander
         */
    //endregion
}
