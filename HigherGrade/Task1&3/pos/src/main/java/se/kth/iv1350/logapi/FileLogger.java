package se.kth.iv1350.logapi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Printing log messages to a file in the same directory named "log.txt".
 * These log messages are exception messages along with the time they occur.
*/
public class FileLogger {
    private PrintWriter logStream;

    /**
     * Creates a new instance of the FileLogger class and a new file. 
     * An already existing log file will be deleted after each call to the constructor.
     */
    public FileLogger() {
        try{
            logStream = new PrintWriter(new FileWriter("log.txt"));
        }catch(IOException e) {
            System.out.println("cannot LOG");
            e.printStackTrace();
        }
    }

    private String getCurrentTime(){
        LocalDateTime time = LocalDateTime.now();
        String formattedTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return formattedTime;
    }

    /**
     * Formats and prints an exception along with a timestamp message to the log file.
     *
     * @param exceptionMessage The string that will be printed to the log file.
    */
   
    public void log(Exception exceptionMessage) {
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append("\nAn exception was thrown at ");
        messageToLog.append(getCurrentTime());
        messageToLog.append(" :");
        messageToLog.append("\n< " + exceptionMessage.getMessage() + " >");
        
        logStream.println( messageToLog + "\n");
        exceptionMessage.printStackTrace(logStream);

        logStream.flush();
    }
}
