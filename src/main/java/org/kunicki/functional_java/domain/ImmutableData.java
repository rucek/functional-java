package org.kunicki.functional_java.domain;

class ImmutableData {
    public final Long id;
    public final String value;

    public ImmutableData(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    // equals, hashCode, toString
}
