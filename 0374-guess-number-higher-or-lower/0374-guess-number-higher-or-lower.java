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
        int startNumber = 0;
        int endNumber = n;

        while (startNumber <= endNumber) {
            int myGuess = (int) (((long) endNumber + startNumber) / 2);
            if (guess(myGuess) == 0) {
                return myGuess;
            } else if (guess(myGuess) < 0) {
                endNumber = myGuess - 1;
            } else {
                startNumber = myGuess + 1;
            }
        }
        return -1;
    }
}