import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            map.put(x[i], map.containsKey(x[i]) ? Math.max(map.get(x[i]), y[i]) : y[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : map.values()) {
            pq.offer(i);
        }

        if (pq.size() < 3) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] x = new int[] { 1, 2, 1, 2 };
        int[] y = new int[] { 4, 5, 6, 7 };

        System.out.println(maxSumDistinctTriplet(x, y));
    }
}