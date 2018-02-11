package com.toreforge;

public enum Cell {
    EMPTY,
    BARIER,
    FRUIT,
    BODY,
    HEAD;

    @Override
    public String toString() {
        switch (this) {
            case BODY: return "B";
            case HEAD: return "H";
            case EMPTY: return " ";
            case FRUIT: return "O";
            case BARIER: return "X";
        }
        return null;
    }
}
