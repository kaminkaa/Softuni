import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class PointInFigure {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int h = Integer.parseInt(console.nextLine());
        int x = Integer.parseInt(console.nextLine());
        int y = Integer.parseInt(console.nextLine());

        int x1Rect1 = 0;
        int x2Rect1 = 3*h;
        int y1Rect1 = 0;
        int y2Rect1 = h;

        int x1Rect2 = h;
        int x2Rect2 = 2*h;
        int y1Rect2 = h;
        int y2Rect2 = 4*h;

        boolean isOutsideRect1 = x<x1Rect1 || x>x2Rect1 || y<y1Rect1 || y>y2Rect1;
        boolean isOutsideRect2 = x<x1Rect2 || x>x2Rect2 || y<y1Rect2 || y>y2Rect2;

        boolean isInsideRect1 = x>x1Rect1 && x<x2Rect1 && y>y1Rect1 && y<y2Rect1;
        boolean isInsideRect2 = x>x1Rect2 && x<x2Rect2 && y>y1Rect2 && y<y2Rect2;
        boolean isOnCommonBorder = x>x1Rect2 && x<x2Rect2 && y==y1Rect2;

        if(isOutsideRect1 && isOutsideRect2){
            System.out.println("outside");
        } else if (isInsideRect1 || isInsideRect2 || isOnCommonBorder){
            System.out.printf("inside");
        } else {
            System.out.printf("border");
        }
    }
}
