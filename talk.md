

# Disclaimer
Everything here would probably be counter-intuitive at first

# Functional Programming
##
- FP = pure functions + immutable values
##
- immutable values can be safely passed around
##
- pure functions can be memoized
##
- pure functions are suitable for property-based testing
##
- "easier to reason about" - buzzword, but it's true

# Functional error handling
## 
- algebraic data types
###
    - types formed by combining other types
###
    - aggregation vs choice
###
    - aggregation: record - (cartesian) product
###
    - choice: sealed hierarchy - sum (disjoint union, coproduct)
###
    - illegal states are unrepresentable

# Validation
##
- monads - e.g. `Either`
###
    - allow to sequence dependent computations
###
    - fail fast (short circuit)
##
- applicatives (applicative functors) - e.g. `Validation`
###
    - allow to run computations independently
###
    - accumulate the results

# Takeaways
##
- try to think in pure functions and immutable values
##
- avoid exceptions for flow control - errors can be values too
##
- leverage the power of ADTs and pattern matching [https://sml.io/java-21-switch]
##
- monads do not bite, neither do applicatives, functors etc.
##
- read "Functional Programming Simplified" by Alvin Alexander
