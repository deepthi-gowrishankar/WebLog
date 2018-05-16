
/**
 * Write a description of CountTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class CountTester {

    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        //System.out.println(counts);
        //int maxVisits = la.mostNumberVisitsByIP(counts);
        //System.out.println("Max Visits: " + maxVisits);
        ArrayList<String> most = la.iPsMostVisits(counts);
        //System.out.println(most);
        HashMap<String, ArrayList<String>> ipDay = la.iPsForDays();
        //System.out.println(ipDay);
        //String dayWithMost = la.dayWithMostIPVisits(ipDay);
        //System.out.println(dayWithMost);
        ArrayList<String> iPsMostVisits = la.iPsWithMostVisitsOnDay(ipDay, "Sep 30");
        System.out.println(iPsMostVisits);
    }
    
}
