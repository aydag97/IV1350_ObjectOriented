package se.kth.iv1350.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {

    private PrintWriter logStream;
    private double totalRevenue;

    public TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            logStream = new PrintWriter(new FileWriter("RevenueLog.txt"), true);
        } catch (IOException e) {
            System.out.println("cannot LOG");
            e.printStackTrace();
        }
    }

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
