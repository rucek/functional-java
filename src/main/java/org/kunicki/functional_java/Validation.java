package org.kunicki.functional_java;

record Person(String name, int age) {
}

interface PersonValidator {

    //region Common validation logic
    default boolean isNameValid(String name) {
        return name.startsWith("M");
    }

    default boolean isAgeValid(int age) {
        return age == 38;
    }
    //endregion
}

class FailingFast implements PersonValidator {

}

class Accumulating implements PersonValidator {

}
