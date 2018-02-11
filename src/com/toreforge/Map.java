package com.toreforge;

import com.toreforge.exception.InvalidInputFileException;
import com.toreforge.exception.InvalidMapException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Map {
    private Integer width;
    private Integer height;
    private HashMap<Integer, Row> rows;

    public Map(String filename) {
        load(filename);
    }

    public void load(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                processLine(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidMapException e) {
            e.printStackTrace();
        } catch (InvalidInputFileException e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) throws InvalidInputFileException, InvalidMapException {
        if (height == null)
            height = 0;
        else
            height++;
        char[] chars = line.toCharArray();
        if (width == null)
            width = chars.length;
        if (width != chars.length)
            throw new InvalidInputFileException();
        rows.put(height, new Row());

        int position = 0;
        for (char c : chars) {
            switch (c) {
                case ' ': rows.get(height).addCell(position, Cell.EMPTY); break;
                case 'X': rows.get(height).addCell(position, Cell.BARIER); break;
                case 'O': rows.get(height).addCell(position, Cell.FRUIT); break;
                case 'B': rows.get(height).addCell(position, Cell.BODY); break;
                case 'H': rows.get(height).addCell(position, Cell.HEAD); break;
                default: throw new InvalidMapException();
            }
        }
    }
}
