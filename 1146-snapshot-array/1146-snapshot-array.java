import java.util.*;

class SnapshotArray {
    // For each index, store a list of [snap_id, value] pairs recorded at the time of the set() call.
    // Only the snap_id at which a change happens is recorded, so binary search finds
    // the most recent value at or before the queried snap_id.
    private List<List<int[]>> history;
    private int snapId;

    public SnapshotArray(int length) {
        history = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{0, 0}); // initial value 0 at snap_id 0
            history.add(list);
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
        List<int[]> list = history.get(index);
        // If the current snapId already has an entry (multiple sets before a snap),
        // overwrite it instead of adding a duplicate entry for the same snapId.
        if (list.get(list.size() - 1)[0] == snapId) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = history.get(index);
        int pos = binarySearch(list, snap_id);
        // pos is the first index where entry's snap_id > target,
        // so pos - 1 is the most recent entry with snap_id <= target
        return list.get(pos - 1)[1];
    }
    
    // Finds the leftmost index where list[index][0] > target
    private int binarySearch(List<int[]> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid)[0] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */