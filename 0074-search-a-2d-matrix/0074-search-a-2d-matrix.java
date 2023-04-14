class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beginI = 0;
        int beginJ = 0;

        int endI = matrix.length - 1;
        int endJ = matrix[0].length - 1;

        while (beginI <= endI && beginJ <= endJ) {
            int midI = (beginI + endI) / 2;
            int midJ = (beginJ + endJ) / 2;

            int midElem = matrix[midI][midJ];
            if (midElem == target) {
                return true;
            } else if (target < midElem) {
                endJ = midJ - 1;
                if (endJ < 0) {
                    endI--;
                    endJ = matrix[0].length - 1;
                }
            } else {
                beginJ = midJ + 1;
                if (beginJ > matrix[0].length - 1) {
                    beginI++;
                    beginJ = 0;
                }
            }
        }
        return false;
    }
}