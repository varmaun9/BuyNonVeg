package com.meat.constants;

public enum Percentage {

    Percent("0"),
    Direct("1");

    private String sequenceName;

    Percentage(final String sequenceCode) {
        sequenceName = sequenceCode;
    }

    public String getSequenceName() {
        return sequenceName;
    }

}
