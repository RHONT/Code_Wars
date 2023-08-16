package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        int[][] newArr = new int[][]{{2, 4}, {7, 8}, {11, 12}, {45, 50}};

        int[] starts = Stream.of(newArr).mapToInt(x -> x[0]).toArray();
        int[] ends = Stream.of(newArr).mapToInt(x -> x[1]).toArray();

        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
        System.out.println("---".repeat(3));

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        fillArrSelectedIndex(starts, intervals, 0, start);
        fillArrSelectedIndex(ends, intervals, 1, end);
        System.out.println(starts);
        System.out.println(ends);

        return intervals;
    }

    private void fillArrSelectedIndex(List<Integer> arr, int[][] intervals, int idx, int newIntervalPart) {
        boolean stop = false;
        for (int j = 0; j < intervals.length; j++) {
            if (!stop) {
                if (intervals[j][idx] < newIntervalPart) {
                    arr.add(intervals[j][idx]);
                } else {
                    arr.add(newIntervalPart);
                    arr.add(intervals[j][idx]);
                    stop = true;
                }
            } else arr.add(intervals[j][idx]);

        }
        if (!stop) {
            arr.add(newIntervalPart);
        }
    }

}
