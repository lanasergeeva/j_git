package ru.job4j.ex.map;

public record Label(String name, double score) implements Comparable<Label> {
    public static final String CHANGE = "change";

    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
