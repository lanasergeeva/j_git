package ru.job4j.ex.array;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        char[] chars = name.toCharArray();
        return chars.length >= 1 && validFirst(chars[0]) && check(chars);
    }

    private static boolean check(char[] chars) {
        boolean rsl = true;
        for (int i = 1; i < chars.length; i++) {
            if (!validOther(chars[i])) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    private static boolean validOther(char symbol) {
        return symbol == '$' || symbol == '_' || (symbol >= '0' && symbol <= '9')
                || (symbol >= 'A' && symbol <= 'Z') || validFirst(symbol);
    }

    private static boolean validFirst(char symbol) {
        return symbol >= 'a' && symbol <= 'z';
    }
}
