class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                    ? Long.compare(a[1], b[1])
                    : Long.compare(a[0], b[0])
        );
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.offer(i);

        int[] count = new int[n];
        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];
            long duration = end - start;
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                freeRooms.offer((int) pq.poll()[1]);
            }
            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                pq.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] top = pq.poll();
                long newEnd = top[0] + duration;
                pq.offer(new long[]{newEnd, top[1]});
                count[(int) top[1]]++;
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }
        return res;
    }
}
