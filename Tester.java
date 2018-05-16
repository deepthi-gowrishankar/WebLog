
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("short-test_log");
        la.printAll();
        // create log analyzer object
        // call readFile on data file short-test_log
        // call printAll
    }
    
    public void testUniqueIPs() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPs() + " unique IPs");
        // create log analyzer object
        // call readFile on data file short-test_log
        // call printAll
    }
    
    public void testHigher() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("weblog2_log");
        //System.out.println(la.countUniqueIPs());
        //la.printAllHigherThanNum(400);
        //System.out.println(la.uniqueIPVisitsOnDay("Sep 14"));
        ArrayList<String> uniqueIP= la.uniqueIPVisitsOnDay("Sep 24");
        //System.out.println(uniqueIP);
        //System.out.println(uniqueIP.size());
        System.out.println(la.countUniqueIPsInRange(200,299));
        // System.out.println(la.countUniqueIPsInRange(300,399));
        // create log analyzer object
        // call readFile on data file short-test_log
        // call printAll
    }
}
