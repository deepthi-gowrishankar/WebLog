
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
         //initialize records to an empty arrayList
     }
        
     public void readFile(String filename) {
         // complete method
         //determine file name to read from
         //create fileresource
         FileResource fr = new FileResource(filename);
         // iterate over all the lines
         for (String line : fr.lines()) {
             LogEntry log = WebLogParser.parseEntry(line);
             records.add(log);
            }
         // for each line
         // use WebLogParser.parseEntry() to convert
         // create a LogEntry
         // store it in the records ArrayList
     }
     
     public HashMap<String,Integer> countVisitsPerIP() {
         //Make an empty HashMap counts
         HashMap<String, Integer> counts = new HashMap<String,Integer>();
         // For each le in records
         for (LogEntry le : records) {
            //ip is le's IP address
            String ip = le.getIpAddress();
            //check if ip is in counts
                if (! counts.containsKey(ip)) {
                //if not: put ip in with a value of 1
                    counts.put(ip, 1);
                //else, add one to integer in counts
               }
               else {
                   counts.put(ip,counts.get(ip) + 1);
            }
         }
         //return counts
         return counts;
     }
     
     public int mostNumberVisitsByIP (HashMap<String,Integer> counts) {
         int maxVisits = 0;
         
         for (int count : counts.values()) {
             if (count>maxVisits) {
                 maxVisits = count;
             }
         }
         
         return maxVisits;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer>counts ) {
         int maxVisits = mostNumberVisitsByIP(counts);
         int current;
         ArrayList<String> most = new ArrayList<String>();
         for (String ip : counts.keySet()){
             current = counts.get(ip);
             if (current == maxVisits) { 
                 most.add(ip);
                }
            }
         
         return most;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> ipDay = new HashMap<String,ArrayList<String>>();
        
         for (LogEntry le : records) {
             String dateFull = le.getAccessTime().toString();
             String date = dateFull.substring(4,10);
             String IP = le.getIpAddress();
             if (! ipDay.containsKey(date)) {
                 ipDay.put(date, new ArrayList<String>());
                }
             ipDay.get(date).add(IP);
            }
        
        return ipDay;
        
     }
     
     public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> ipDay){
         String mostDay = "";
         int max = 0;
         int curr;
         
         for (String time : ipDay.keySet()){
             curr = ipDay.get(time).size();
             if (curr > max) {
                 max = curr;
                 mostDay = time;
                }
         }
         
         return mostDay;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> ipDay, String day) {
         ArrayList<String> list = ipDay.get(day);
         HashMap<String, Integer> count = new HashMap<String, Integer>();
          for (String ip : list ) {
              if (! count.containsKey(ip)) {
                  count.put(ip,1);
                }
               count.put(ip, count.get(ip) + 1);
            }
         
         ArrayList<String> ipMostVisits = iPsMostVisits(count);
         
         return ipMostVisits;
        }
     
     public int countUniqueIPs() {
         //uniqueIPs empty list
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         //for each element le in records
         for (LogEntry le : records) {
         //ipAddr is le's ipAddress
            String ipAddr = le.getIpAddress();
         //if ipAddr is not in unique IPs 
            if (! uniqueIPs.contains(ipAddr)) {
             //add ipAddr to unique IPs
            uniqueIPs.add(ipAddr);
           }
        }
         // return size of IPs
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num) {
         ArrayList<Integer> uniqueStatus = new ArrayList<Integer>();
         for (LogEntry le : records) {
             int status = le.getStatusCode();
             if (status > num) {
                 if (! uniqueStatus.contains(status)){
                     uniqueStatus.add(status);
                     System.out.println(le);
                    }
                 
         
                }
            }
     }
     
     public ArrayList uniqueIPVisitsOnDay (String someday) {
         ArrayList<String> uniqueIPOnDay = new ArrayList<String>();
         for (LogEntry le : records) {
             
             String dateFull = le.getAccessTime().toString();
             String date = dateFull.substring(4,10);
             if (someday.equals(date)) {
                 String IP = le.getIpAddress();
                 if (! uniqueIPOnDay.contains(IP)) {
                 uniqueIPOnDay.add(IP);
                }
             
            }
        }
        return uniqueIPOnDay;
     }
     
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
             int status = le.getStatusCode();
             //System.out.println(status);
             String IP = le.getIpAddress();
             if (status >= low && status <= high) {
                 if (! uniqueIPs.contains(IP)){
                     uniqueIPs.add(IP);
                     System.out.println(IP);
                    }
                 
         
                }
            }
         return uniqueIPs.size();
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
