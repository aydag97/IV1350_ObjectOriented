package se.kth.iv1350.logapi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import se.kth.iv1350.model.SaleObserver;


/**
 * TotalRevenueFileOutput is responsible for logging the total revenue to a file.
 * It implements the SaleObserver interface to update and log the revenue when notified.
 */
public class TotalRevenueFileOutput implements SaleObserver {

    private PrintWriter logStream;
    private double totalRevenue;
    
    /**
     * Creates a new instance of TotalRevenueFileOutput and initializes the log file.
     * If the log file cannot be created, prints an error message and stack trace.
     */
    public TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            logStream = new PrintWriter(new FileWriter("RevenueLog.txt"), true);
        } catch (IOException e) {
            System.out.println("cannot LOG");
            e.printStackTrace();
        }
    }

    /**
     * Updates the total revenue and logs the new total to the file.
     *
     * @param totalRevenue The revenue from the latest sale to be added to the total.
     */
    @Override
    public void updateRevenue(double totalRevenue) {
        this.totalRevenue += totalRevenue;
        log();
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
    public void log() {
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append("Current total revenue at ");
        messageToLog.append(getCurrentTime());
        messageToLog.append(" is: ");
        messageToLog.append(this.totalRevenue + " kr.");
        logStream.println(messageToLog + "\n");
    }
}
