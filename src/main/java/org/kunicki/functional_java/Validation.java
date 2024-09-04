package org.kunicki.functional_java;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Validation;

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

class Validator1 implements PersonValidator {
    public void validate(String name, int age) {
        // (valid name, valid age) -> Person
        final Either<String, String> validatedName = validateName(name);
        final Either<String, Integer> validatedAge = validateAge(age);

        final Either<String, Person> result = validatedName.flatMap(n ->
            validatedAge.map(a ->
                new Person(n, a))
        );
    }

    private Either<String, String> validateName(String name) {
        return isNameValid(name) ? Either.right(name) : Either.left("Invalid name");
    }

    private Either<String, Integer> validateAge(int age) {
        return isAgeValid(age) ? Either.right(age) : Either.left("Invalid age");
    }
}

class Validator2 implements PersonValidator {
    public void validate(String name, int age) {
        // (valid name, valid age) -> Person
        final Validation<String, String> validatedName = validateName(name);
        final Validation<String, Integer> validatedAge = validateAge(age);

        final Validation<Seq<String>, Person> result = Validation.combine(validatedName, validatedAge).ap(Person::new);
    }

    private Validation<String, String> validateName(String name) {
        return isNameValid(name) ? Validation.valid(name) : Validation.invalid("Invalid name");
    }

    private Validation<String, Integer> validateAge(Integer age) {
        return isAgeValid(age) ? Validation.valid(age) : Validation.invalid("Invalid age");
    }
}
