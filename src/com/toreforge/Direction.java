package com.toreforge;

public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction fromString(String s) {
        switch (s.toUpperCase()) {
            case "R": return RIGHT;
            case "L": return LEFT;
            case "U": return UP;
            case "D": return DOWN;
        }
        return RIGHT;
    }
}
