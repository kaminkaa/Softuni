import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class Cup {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int i;

        for (i=0; i<n/2; i++){
            System.out.printf("%s", repeatStr(".",n+i));
            System.out.printf("%s", repeatStr("#",5*n-2*(n+i)));
            System.out.printf("%s", repeatStr(".",n+i));
            System.out.println();
        }

        for (int j=0; j<n/2+1; j++){
            System.out.printf("%s", repeatStr(".",n+i));
            System.out.printf("%s", repeatStr("#",1));
            System.out.printf("%s", repeatStr(".",5*n-2*(n+i)-2));
            System.out.printf("%s", repeatStr("#",1));
            System.out.printf("%s", repeatStr(".",n+i));
            System.out.println();
            i++;
        }

        System.out.printf("%s", repeatStr(".",n+i-1));
        System.out.printf("%s", repeatStr("#",5*n-2*(n+i-1)));
        System.out.printf("%s", repeatStr(".",n+i-1));
        System.out.println();

        for (int k=0; k<n/2; k++){
            System.out.printf("%s", repeatStr(".",2*n-2));
            System.out.printf("%s", repeatStr("#",5*n-2*(2*n-2)));
            System.out.printf("%s", repeatStr(".",2*n-2));
            System.out.println();
        }

        System.out.printf("%s", repeatStr(".",(5*n-10)/2));
        System.out.printf("%s", repeatStr("D^A^N^C^E^",1));
        System.out.printf("%s", repeatStr(".",(5*n-10)/2));
        System.out.println();

        for (int k=0; k<n/2+1; k++){
            System.out.printf("%s", repeatStr(".",2*n-2));
            System.out.printf("%s", repeatStr("#",5*n-2*(2*n-2)));
            System.out.printf("%s", repeatStr(".",2*n-2));
            System.out.println();
        }
    }

    public  static String repeatStr (String str, int count){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
