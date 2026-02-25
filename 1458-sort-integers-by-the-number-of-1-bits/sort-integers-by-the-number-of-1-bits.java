import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            if (bitA == bitB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(bitA, bitB);
        });
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}
