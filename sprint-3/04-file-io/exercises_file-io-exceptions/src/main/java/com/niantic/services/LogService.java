package com.niantic.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogService {
    private String logType;

    public LogService(String logType) {
        this.logType = logType;
        ensureDirectoryExists(logType);
    }

    private void ensureDirectoryExists(String dirName) {
        File directory = new File(dirName);

        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private File getLogFile() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = logType + "/" + today.format(formatter) + ".log";
        return new File(fileName);
    }

    public void logMessage(String message) {
        var file = getLogFile();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (FileOutputStream stream = new FileOutputStream(file, true);
             PrintWriter out = new PrintWriter(stream)) {
            out.printf("%s %s\n", now.format(formatter), message);
        } catch (Exception e) {
            // swallow
        }
    }

}
