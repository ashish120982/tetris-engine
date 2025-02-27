package com.drwdom.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.drwdom.constants.TetrisEngineConstants;

/**
 * The TextFileReader class implements the InputReader interface to read input from a text file.
 * It uses Files utility class to read the contents of the file.
 */
public class TextFileReader implements InputReader {

    /**
     * Reads the input from the file and returns a list of strings representing the lines of the file.
     * Uses Files utility class to read the file from resources.
     *
     * @return a list of strings representing the lines of the file
     * @throws RuntimeException if the input file is not found or an IOException occurs
     */
    @Override
    public List<String> readInput() {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(TetrisEngineConstants.FILE_NAME).toURI());
            return Files.readAllLines(path);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Error reading input file", e);
        }
    }
}
