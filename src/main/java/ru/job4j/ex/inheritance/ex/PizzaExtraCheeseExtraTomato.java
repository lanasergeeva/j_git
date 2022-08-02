package ru.job4j.ex.inheritance.ex;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public static final String NEED_MORE_TOMATO = " double tomato";

    @Override
    public String name() {
        return super.name() + NEED_MORE_TOMATO;
    }
}
