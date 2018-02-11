package com.toreforge;

import com.toreforge.exception.InvalidMapException;

import java.util.HashMap;

public class Row {
    private HashMap<Integer, Cell> cells = new HashMap<>();

    public void addCell(Integer position, Cell cell) throws InvalidMapException {
        if (cells.containsKey(position))
            throw new InvalidMapException();
        cells.put(position, cell);
    }

    public Cell getCell(Integer position) throws InvalidMapException {
        if (!cells.containsKey(position))
            throw new InvalidMapException();
        return cells.get(position);
    }

}
