/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 * 
 * Q.1 Busiest: 18, 10, 14
 * 
 * Q.2 Person[] person
 * 
 * Q.3 boolean[] vacant
 * 
 * Q.4 Constructor, analyzeHourlyData(), printHourlyCounts(). 2 times
 * 
 * Q.5 int[] counts;
 *     occupied = new boolean[5000];
 *     
 * Q.6 a) readings = new double[60];
 *     b) urls = new String[90];
 *     c) machine = new TicketMachine[5]
 *     
 * Q.7 20
 * 
 * Q.8 double[] prices = new double[50];
 * 
 * Q.9 Index out of bounds
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    public LogAnalyzer(String filename) //12
    {
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        /*for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }*/
        int hour = 0; //Q. 10
        while(hour < hourCounts.length)
        {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    public void printGreater(double mean) //Q.11
    {
        double[] marks = {1.1, 5.7, 6.6, 9.2, 10.4};
        for(int index = 0; index < marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            }
        }
    }
}
