package org.kunicki.functional_java.domain;

//region Immutable Data

class ImmutableData {

    public final Long id;

    public final String value;

    public ImmutableData(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public ImmutableData withValue(String value) {
        return new ImmutableData(this.id, value);
    }
}
//endregion

//region Record
//endregion

//region Record test

class RecordTest {

    public static void main(String[] args) {

    }
}
//endregion
