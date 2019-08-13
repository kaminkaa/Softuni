/**
 * Created by Cammi on 21/07/2017.
 */
public class Rectangleof10x10Stars {
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            System.out.println(repeatStr("*",10));
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
