package com.drwdom.factories;

import static com.drwdom.constants.TetrisEngineConstants.TEXT_FILE;

import com.drwdom.reader.InputReader;
import com.drwdom.reader.TextFileReader;

/**
 * Factory class to create input readers based on the specified type.
 */
public class InputReaderFactory {

    /**
     * Creates an input reader based on the specified type.
     * 
     * @param type the type of input reader to create
     * @return the created input reader
     * @throws IllegalArgumentException if the reader type is unknown
     */
    public static InputReader createInputReader(String type) {
        return switch (type) {
            case TEXT_FILE -> new TextFileReader();
            // Future extensions can be added here, e.g., for other types of readers
            default -> throw new IllegalArgumentException("Unknown reader type: " + type);
        };
    }
}
