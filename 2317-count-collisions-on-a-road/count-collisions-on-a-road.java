class Solution {
    public int countCollisions(String directions) {
        char[] directionArray = directions.toCharArray();
        int length = directionArray.length;
      
        int leftBoundary = 0;
        while (leftBoundary < length && directionArray[leftBoundary] == 'L') {
            leftBoundary++;
        }
        int rightBoundary = length - 1;
        while (rightBoundary >= 0 && directionArray[rightBoundary] == 'R') {
            rightBoundary--;
        }
        int totalCollisions = rightBoundary - leftBoundary + 1;
      
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            if (directionArray[i] == 'S') {
                totalCollisions--;
            }
        }
      
        return totalCollisions;
    }
}
