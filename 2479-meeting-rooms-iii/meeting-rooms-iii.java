class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int roomId = 0; roomId < n; roomId++) {
            availableRooms.offer(roomId);
        }
        int[] meetingCount = new int[n];
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= startTime) {
                int[] finishedRoom = busyRooms.poll();
                availableRooms.offer(finishedRoom[1]);
            }
            int assignedRoom;
            if (!availableRooms.isEmpty()) {
                assignedRoom = availableRooms.poll();
                busyRooms.offer(new int[] { endTime, assignedRoom });
            } else {
                int[] earliestRoom = busyRooms.poll();
                assignedRoom = earliestRoom[1];
                int delayedEndTime = earliestRoom[0] + (endTime - startTime);
                busyRooms.offer(new int[] { delayedEndTime, assignedRoom });
            }
            meetingCount[assignedRoom]++;
        }
        int mostUsedRoom = 0;
        for (int roomId = 0; roomId < n; roomId++) {
            if (meetingCount[roomId] > meetingCount[mostUsedRoom]) {
                mostUsedRoom = roomId;
            }
        }
        return mostUsedRoom;
    }
}
