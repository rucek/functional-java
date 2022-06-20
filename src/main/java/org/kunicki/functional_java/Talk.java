package org.kunicki.functional_java;

/**
 * @title Fear not the unknown, my friend. And go FP.
 *
 * @author Jacek Kunicki
 * @company SoftwareMill
 *
 * @twitter https://twitter.com/rucek
 */
public class Talk {

    //region Disclaimer
    // Everything here would probably be counter-intuitive at first
    //endregion

    //region Functional Programming
        /*
         * FP = pure functions + immutable values
         */
        /*
         * immutable values can be safely passed around
         */
        /*
         * thread-safe - can be safely parallelized
         */
        /*
         * suitable for property-based testing
         */
        /*
         * easier to reason about - buzzword, but it's true
         */
    //endregion

    //region Functional error handling
    //endregion

    //region Algebraic Data Types
        /*
         * types formed by combining other types
         */
        /*
         * (cartesian) product
         */
        /*
         * sum (disjoint union, coproduct)
         */
    //endregion

    //region Validation, or monads vs applicatives

        //* monads
            /*
             * allow to sequence dependent computations
             */
            /*
             * fail fast
             */

        //* applicatives (applicative functors)
            /*
             * allow to run computations independently
             */
            /*
             * accumulate the results
             */
    //endregion

    //region Bonus: framework-less DI
        /*
         * Over-engineering?
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
         * --enable-preview
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
