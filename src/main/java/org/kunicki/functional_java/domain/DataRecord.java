package org.kunicki.functional_java.domain;

record DataRecord(Long id, String value) {
    // equals, hashCode, toString - come for free
}

//region Record test

class RecordTest {

    public static void main(String[] args) {
        System.out.println(STR."\nClassic:\n\{new ImmutableData(2024L, "JavaZone")}\n");
        System.out.println(STR."Record:\n\{new DataRecord(2024L, "JavaZone")}");
    }
}
//endregion
