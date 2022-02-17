package com.br.finance.enumeration;

public enum TypeExpenseEnum {

    EXPENDITURE("Expenditure"),
    SPENT("Spent");

    TypeExpenseEnum(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
