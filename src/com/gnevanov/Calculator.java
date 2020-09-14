package com.gnevanov;

public class Calculator {

    public enum Command {
        SUM,
        DIV,
        SUBSTRACT,
        POWER,
    }

    public int calculate(Command command, int argument1, int argument2) {
        int argument1Abs = Math.abs(argument1);
        int argument2Abs = Math.abs(argument2);
        return switch (command) {
            case SUM -> sum(argument1Abs, argument2Abs);
            case DIV -> div(argument1Abs, argument2Abs);
            case SUBSTRACT -> substract(argument1Abs, argument2Abs);
            case POWER -> power(argument1Abs, argument2Abs);
            default -> throw new UnsupportedOperationException("Unknown operation " + command);
        };

    }

    public int sum(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public int div(int divined, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be zero!");
        }
        return divined / divisor;
    }

    public int substract(int arg1, int arg2) {
        return arg1 - arg2;
    }

    public int power(int arg1, int arg2) {
        return arg1 * arg2;
    }

}
