import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int screenLength = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(", ");

        char[][] matrix = new char[screenLength][screenLength];
        int[] startPos = new int[2];
        int foodCount = 0;

        for (int r = 0; r < screenLength; r++){
            String[] lineChars = reader.readLine().split(" ");
            for (int c = 0; c < screenLength; c++){
                matrix[r][c] = lineChars[c].charAt(0);
                if (lineChars[c].equals("s")){
                    startPos[0] = r;
                    startPos[1] = c;
                }
                if (lineChars[c].equals("f")){
                    foodCount++;
                }
            }
        }

        int snakeLength = 1;
        int foodEaten = 0;
        boolean steppedOnEnemy = false;
        int[] currentPos = new int[2];
        currentPos[0] = startPos[0];
        currentPos[1] = startPos[1];

        loop:
        for (String command : commands){
            switch (command){
                case "right":
                    currentPos[1]++;
                    if (currentPos[1] > screenLength - 1) { currentPos[1] = 0; }
                    if (stepOnFood(currentPos,matrix)) { foodEaten++; snakeLength++; }
                    if (stepOnEnemy(currentPos,matrix)) { steppedOnEnemy = true; break loop; }
                    break;
                case "left":
                    currentPos[1]--;
                    if (currentPos[1] < 0) { currentPos[1] = screenLength - 1; }
                    if (stepOnFood(currentPos,matrix)) { foodEaten++; snakeLength++; }
                    if (stepOnEnemy(currentPos,matrix)) { steppedOnEnemy = true; break loop; }
                    break;
                case "up":
                    currentPos[0]--;
                    if (currentPos[0] < 0) { currentPos[0] = screenLength - 1; }
                    if (stepOnFood(currentPos,matrix)) { foodEaten++; snakeLength++; }
                    if (stepOnEnemy(currentPos,matrix)) { steppedOnEnemy = true; break loop; }
                    break;
                case "down":
                    currentPos[0]++;
                    if (currentPos[0] > screenLength - 1) { currentPos[0] = 0; }
                    if (stepOnFood(currentPos,matrix)) { foodEaten++; snakeLength++; }
                    if (stepOnEnemy(currentPos,matrix)) { steppedOnEnemy = true; break loop; }
                    break;
            }
        }

        if (foodCount == foodEaten){
            System.out.println("You win! Final snake length is " + snakeLength);
        } else if (steppedOnEnemy){
            System.out.println("You lose! Killed by an enemy!");
        } else if (foodCount > foodEaten){
            int foodLeft = foodCount - foodEaten;
            System.out.println("You lose! There is still " + foodLeft + " food to be eaten.");
        }
    }

    private static boolean stepOnFood (int[] currentPos, char[][] matrix){
        return matrix[currentPos[0]][currentPos[1]] == 'f';
    }

    private static boolean stepOnEnemy (int[] currentPos, char[][] matrix){
        return matrix[currentPos[0]][currentPos[1]] == 'e';
    }
}
