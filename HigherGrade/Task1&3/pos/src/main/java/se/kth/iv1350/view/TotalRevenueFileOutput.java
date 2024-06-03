package se.kth.iv1350.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * TotalRevenueFileOutput is responsible for logging the total revenue to a file.
 * It extends TotalRevenueTemplate to update and log the revenue when notified.
 */
public class TotalRevenueFileOutput extends TotalRevenueTemplate {

    private PrintWriter logStream;
    private PrintWriter exceptionLog;
    
    /**
     * Creates a new instance of TotalRevenueFileOutput and initializes the log files.
     * If the log files cannot be created, prints an error message and stack trace.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("RevenueLog.txt"), true);
            exceptionLog = new PrintWriter(new FileWriter("RevenueExceptionLog.txt"), true);
        } catch (IOException e) {
            System.out.println("cannot LOG");
            e.printStackTrace();
        }
    }

    /**
     * Logs the current total income to the log file.
     * This method is called by the parent class when a new sale is made.
     */

    @Override
    public void doShowTotalIncome() {
        log();
    }

    /**
     * Handles any errors by logging them to the exception log file.
     *
     * @param e The exception that was thrown.
     */
    @Override
    public void handleErrors(Exception e){
        exceptionLog.println(e.getMessage());
        exceptionLog.println(e.getCause());
    }

    private String getCurrentTime(){
        LocalDateTime time = LocalDateTime.now();
        String formattedTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return formattedTime;
    }

    private void log() {
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append("Current total revenue at ");
        messageToLog.append(getCurrentTime());
        messageToLog.append(" is: ");
        messageToLog.append(String.format("%.2f kr.", this.currentRevenue));
        logStream.println(messageToLog + "\n");
    }

}
