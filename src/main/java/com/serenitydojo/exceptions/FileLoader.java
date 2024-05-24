package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
    public String readHelloWorld() throws IOException {
        return Files.readString(Paths.get("src/main/resources/hello.txt"));
    }

    public boolean fileContainsText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        try {
            return Files.readString(Paths.get(path)).contains(expectedText);
        } catch (IOException fileDoesNotExist) {
            return false;
        }
    }

    public Boolean fileHasText(String filename, String expectedText )  {
        String path = "src/main/resources/" + filename;
        try {
            return Files.readString(Paths.get(path)).contains(expectedText);
        } catch (IOException fileDoesNotExist) {
            throw new  MissingWelcomeFileException("This file does not exist: " + filename , fileDoesNotExist);
        }
    }
}