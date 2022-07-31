package ru.job4j.ex.stream;

import java.util.StringJoiner;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",
                Card.class.getSimpleName() + "[", "]")
                .add("suit=" + suit)
                .add("value=" + value)
                .toString();
    }
}
