/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  // avoid int overflow

            int result = guess(mid);

            if (result == 0) {
                return mid;          // found it!
            } else if (result == 1) {
                lo = mid + 1;        // pick is higher, go right
            } else {
                hi = mid - 1;        // pick is lower, go left
            }
        }

        return -1; // never reached
    }
}