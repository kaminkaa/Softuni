/**
 * Created by Cammi on 02/10/2017.
 */
public class ExchangeVariableValues {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.printf("Before:");
        System.out.println();
        System.out.printf("a = %d", a);
        System.out.println();
        System.out.printf("b = %d", b);
        System.out.println();
        System.out.printf("After:");
        System.out.println();
        System.out.printf("a = %d", b);
        System.out.println();
        System.out.printf("b = %d", a);
    }
}
