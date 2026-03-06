/**
 * Problem: 635. Design Log Storage System
 * Source: LeetCode
 *
 * Statement:
 * Implement a log storage system that stores logs with timestamps
 * and supports retrieving logs within a given time range and granularity.
 *
 * Functions:
 * - put(id, timestamp): stores the log with given id and timestamp.
 * - retrieve(start, end, granularity): returns ids of logs within the range.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class log{
    int id;
    String timeStamp;
    log(int id,String timeStamp){
        this.id=id;
        this.timeStamp=timeStamp;
    }
}
public class logStorageSystem {
    private ArrayList<log> logEntries;
    HashMap<String, Integer> granularityMap;

    public logStorageSystem() {
        logEntries = new ArrayList<>();
        granularityMap = new HashMap<>();

        granularityMap.put("Year", 4);
        granularityMap.put("Month", 7);
        granularityMap.put("Day", 10);
        granularityMap.put("Hour", 13);
        granularityMap.put("Minute", 16);
        granularityMap.put("Second", 19);
    }

    public void put(int id, String timeStamp) {
        logEntries.add(new log(id, timeStamp));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> ansId = new ArrayList<>();

        int subStringLength = granularityMap.get(granularity);

        String startTruncated = start.substring(0, subStringLength);
        String endTruncated = end.substring(0, subStringLength);

        for (log logEntry : logEntries) {
            String logTSTruncated = logEntry.timeStamp.substring(0, subStringLength);
            if (startTruncated.compareTo(logTSTruncated) <= 0 && logTSTruncated.compareTo(endTruncated) <= 0) {
                ansId.add(logEntry.id);
            }
        }
        return ansId;
    }

    public static void main(String[] args) {
        logStorageSystem logSystem = new logStorageSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2017:01:02:08:30:00");

        System.out.println(logSystem.retrieve("2017:01:01:20:00:00",
                "2017:01:01:23:59:59",
                "Day")); // Output: [1, 2]
    }
}
