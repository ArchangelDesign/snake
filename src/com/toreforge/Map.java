package com.toreforge;

import com.toreforge.exception.InvalidInputFileException;
import com.toreforge.exception.InvalidMapException;

import java.io.*;
import java.util.HashMap;

public class Map {
    private Integer width;
    private Integer height;
    private HashMap<Integer, Row> rows = new HashMap<>();
    private Direction direction;

    public Map() {
    }

    public Direction getDirection() {
        return direction;
    }

    public void load(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();

            if (line.length() != 1)
                throw new InvalidInputFileException();

            direction = Direction.fromString(line);

            line = br.readLine();

            while (line != null) {
                processLine(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("I/O Error.");
        } catch (InvalidMapException e) {
            System.out.println("Provided map is not valid.");
        } catch (InvalidInputFileException e) {
            System.out.println("Input file is not valid.");
        }
    }

    private void processLine(String line) throws InvalidInputFileException, InvalidMapException {
        if (height == null)
            height = 0;
        else
            height++;
        char[] chars = line.toUpperCase().toCharArray();
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
            position++;
        }
    }

    public void outputMap() throws IOException, InvalidMapException {
        File output = new File("output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        for (int row = 0; row < rows.size(); row++) {
            for (int column = 0; column < width; column++) {
                writer.write(rows.get(row).getCell(column).toString());
            }
            writer.newLine();
        }
        writer.close();
    }
}
