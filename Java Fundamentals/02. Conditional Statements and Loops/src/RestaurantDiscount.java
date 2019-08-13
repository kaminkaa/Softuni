import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class RestaurantDiscount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int groupsize = Integer.parseInt(console.nextLine());
        String servicepackage = console.nextLine();

        double discount = 0.0;
        int hallprice = 0;
        int serviceprice = 0;
        String hallname = "";

        if (groupsize<=50){
            hallprice = 2500;
            hallname = "Small Hall";
        } else if (groupsize>50 && groupsize<=100){
            hallprice = 5000;
            hallname = "Terrace";
        } else if (groupsize>100 && groupsize<=120){
            hallprice = 7500;
            hallname = "Great Hall";
        }

        if (servicepackage.equals("Normal")){
            discount = 0.05;
            serviceprice = 500;
        } else if (servicepackage.equals("Gold")){
            discount = 0.1;
            serviceprice = 750;
        } else if (servicepackage.equals("Platinum")){
            discount = 0.15;
            serviceprice = 1000;
        }

        int totalprice = hallprice + serviceprice;
        double discountedprice = totalprice - totalprice*discount;
        double priceperperson = discountedprice/groupsize;

        if(hallprice==0){
            System.out.printf("We do not have an appropriate hall.");
        } else {
            System.out.printf("We can offer you the %s", hallname);
            System.out.println();
            System.out.printf("The price per person is %.2f$", priceperperson);
        }
    }
}
