package ru.job4j.ex.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {
        List<Card> collect = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(level -> new Card(suit, level)))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
