package com.drwdom;

import static com.drwdom.constants.TetrisEngineConstants.TEXT_FILE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drwdom.components.TetrisEngine;
import com.drwdom.factories.InputReaderFactory;
import com.drwdom.reader.InputReader;

/**
 * The TetrisEngineApplication class is the entry point for the Tetris Engine application.
 * It implements CommandLineRunner to execute the application logic upon startup.
 */
@SpringBootApplication
public class TetrisEngineApplication implements CommandLineRunner {

    @Autowired
    private TetrisEngine tetrisEngine;

    public static void main(String[] args) {
        SpringApplication.run(TetrisEngineApplication.class, args);
    }

    /**
     * The run method is executed upon application startup. It reads the input file,
     * processes the input by applying the pieces to the grid through TetrisEngine, 
     * and prints the resulting heights as output.
     *
     * @param args the command-line arguments
     * @throws Exception if an error occurs during execution
     */
    @Override
    public void run(String... args) throws Exception {
        InputReader reader = InputReaderFactory.createInputReader(TEXT_FILE);
        List<String> inputLines = reader.readInput();
        // Apply the pieces to the grid and get the resulting heights
        List<String> outputLines = tetrisEngine.applyPiecesToGrid(inputLines);
        outputLines.forEach(System.out::println);
    }
}
