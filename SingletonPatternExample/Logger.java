package creational.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static volatile Logger _instance;
    private LogLevel logLevel;
    private List<String> logs;
    private PrintWriter fileWriter;

    // Private constructor to enforce singleton
    private Logger() {
        logLevel = LogLevel.INFO;
        logs = new ArrayList<>();
        try {
            // Append mode
            fileWriter = new PrintWriter(new FileWriter("server.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Optional: Close fileWriter on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }));
    }

    // Double-checked locking for thread safety
    public static Logger getInstance() {
        if (_instance == null) {
            synchronized (Logger.class) {
                if (_instance == null) {
                    _instance = new Logger();
                }
            }
        }
        return _instance;
    }

    // Set the current log level
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    // Log a message if it meets the minimum level
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String log = String.format("[%s] [%s] %s", level, LocalDateTime.now(), message);
            System.out.println(log);
            fileWriter.println(log);
            fileWriter.flush();
            logs.add(log);
        }
    }

    // Display all logs from memory
    public void displayLogs() {
        System.out.println("In-memory logs:");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both loggers of the same reference? " + (logger1 == logger2));

        logger1.setLogLevel(LogLevel.TRACE);
        System.out.println("\nTRACE level defined...");
        logger1.log(LogLevel.TRACE, "trace level log message");
        logger1.log(LogLevel.DEBUG, "debug level log message");
        logger1.log(LogLevel.INFO, "info level log message");
        logger1.log(LogLevel.WARN, "warn level log message");
        logger1.log(LogLevel.ERROR, "error level log message");

        System.out.println("\nDisplaying all logged messages...");
        logger1.displayLogs();
    }
}
