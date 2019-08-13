import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class Diamond {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        System.out.printf("%s",repeatStr(".",n));
        System.out.printf("%s",repeatStr("*",3*n));
        System.out.printf("%s",repeatStr(".",n));
        System.out.println();

        for (int i=n-1; i>0; i--){
            System.out.printf("%s",repeatStr(".",i));
            System.out.printf("*");
            System.out.printf("%s",repeatStr(".",5*n-2*i-2));
            System.out.printf("*");
            System.out.printf("%s",repeatStr(".",i));
            System.out.println();
        }

        System.out.printf("%s",repeatStr("*",5*n));
        System.out.println();

        for (int i=1; i<=2*n; i++) {
            System.out.printf("%s", repeatStr(".", i));
            System.out.printf("*");
            System.out.printf("%s", repeatStr(".", 5 * n - 2 * i - 2));
            System.out.printf("*");
            System.out.printf("%s", repeatStr(".", i));
            System.out.println();
        }

            System.out.printf("%s",repeatStr(".",2*n+1));
            System.out.printf("%s",repeatStr("*",5*n-2*(2*n+1)));
            System.out.printf("%s",repeatStr(".",2*n+1));
    }

    public  static String repeatStr (String str, int count){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
