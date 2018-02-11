package com.toreforge;

import com.toreforge.exception.InvalidMapException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidMapException {
        Processor p = new Processor("input.txt");
        p.writeOutMap();
    }
}
