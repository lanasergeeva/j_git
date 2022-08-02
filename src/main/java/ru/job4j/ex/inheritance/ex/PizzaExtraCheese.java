package ru.job4j.ex.inheritance.ex;

public class PizzaExtraCheese extends Pizza {

    public static final String NEED_MORE_CHEESE = " double cheese";
    @Override
    public String name() {
        return super.name() + NEED_MORE_CHEESE;
    }
}
