package com.meat.constants;

public enum DBSequences {

    SUBCATEGORY("SCAT"),
    ITEM("ITEM"),
    USERS("USER"),
    ADMINUSER("AUSER"),
    CATEGORY("CATG"),
    OFFER("OFFER"),
    ORDER("ORDR"),
    SELLER("SLLR"),
    CUSTOMER("CUST"),
    SUBORDER("SO"),
    PREORDERCARTITEMS("CART"),
    PREORDERQCARTITEMS("QCART"),
    SELLERUSER("SLRUSR"),
    COUPON("COUPON"),
    ORDERITEM("ORDRITM"),
    SELLERINVOICE("BNVSINV"),
    MEATINVOICE("BNVMINV"),
    RECEIPT("BNVRE");

    private String sequenceName;

    DBSequences(final String sequenceCode) {
        sequenceName = sequenceCode;
    }

    public String getSequenceName() {
        return sequenceName;
    }

}
