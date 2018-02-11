package com.toreforge;

import com.toreforge.exception.InvalidMapException;

import java.io.IOException;

public class Processor {
    private Map map = new Map();

    public Processor(String inputFile) {
        map.load(inputFile);
    }

    public void writeOutMap() throws IOException, InvalidMapException {
        map.outputMap();
    }

    public void processSnake() {
        process(map.getDirection());
    }

    private void process(Direction dir) {
        // process snake
    }
}
