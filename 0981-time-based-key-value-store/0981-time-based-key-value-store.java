import java.util.*;

class TimeMap {
    // Maps each key to a list of [timestamp, value] pairs, sorted by timestamp
    // (since set() is called with strictly increasing timestamps for the same key,
    // we can just append to the list and it stays sorted)
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Pair> pairs = map.get(key);
        int pos = binarySearch(pairs, timestamp);
        
        // pos is the index of the first pair with timestamp > target,
        // so pos - 1 is the largest timestamp_prev <= target
        return (pos == 0) ? "" : pairs.get(pos - 1).value;
    }
    
    // Finds the leftmost index where pairs[index].timestamp > target
    private int binarySearch(List<Pair> pairs, int target) {
        int lo = 0, hi = pairs.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (pairs.get(mid).timestamp > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private static class Pair {
        int timestamp;
        String value;
        
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */