import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class AndreyAndBilliard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // read the content of the shop:

        LinkedHashMap<String,Double> shop = new LinkedHashMap<>();
        String[] inputShop;

        for (int i = 0; i < n; i++) {
            inputShop = reader.readLine().split("-");
            shop.put(inputShop[0],Double.parseDouble(inputShop[1]));
        }

        // read what customers buy:

        String[] inputCustomers;
        String customerName,itemToBuy;
        int quantity;
        List<Customer> customers = new ArrayList<>();

        while (true){
            inputCustomers = reader.readLine().split("-|,");
            if (inputCustomers[0].equals("end of clients")){
                break;
            }

            customerName = inputCustomers[0];
            itemToBuy = inputCustomers[1];
            quantity = Integer.parseInt(inputCustomers[2]);

            Customer customer = new Customer(customerName);

            final String name = customerName;

            if (shop.containsKey(itemToBuy)){
                boolean res = customers.stream().anyMatch(e -> e.getName().equals(name));

                if (!res) {
                    if (customer.shoplist.containsKey(itemToBuy)) {
                        int oldQuantity = customer.shoplist.get(itemToBuy);
                        customer.shoplist.put(itemToBuy, oldQuantity + quantity);
                    } else {
                        customer.shoplist.put(itemToBuy, quantity);
                    }

                    customers.add(customer);
                } else {
                    int index = returnIndex(customers, customerName);
                    if (customers.get(index).shoplist.containsKey(itemToBuy)) {
                        int oldQuantity = customers.get(index).shoplist.get(itemToBuy);
                        customers.get(index).shoplist.put(itemToBuy, oldQuantity + quantity);
                    } else {
                        customers.get(index).shoplist.put(itemToBuy, quantity);
                    }
                }
            }
        }

        // set the bill for every customer:

        double currentBill;
        double totalBill = 0;

        for (Customer customer : customers){
            for (Map.Entry<String,Integer> entry : customer.shoplist.entrySet()){
                currentBill = shop.get(entry.getKey()) * entry.getValue();
                totalBill += currentBill;
                customer.setBill(currentBill);
            }
        }

        // print the customer that bought items from the shop:

        Comparator<Customer> compareByName = Comparator.comparing(Customer::getName);

        customers.stream()
                .sorted(compareByName)
                .forEach(customer -> {
                    System.out.printf("%s\n", customer.getName());
                    for (Map.Entry<String,Integer> entry : customer.shoplist.entrySet()){
                        System.out.printf("-- %s - %d\n", entry.getKey(), entry.getValue());
                    }
                    System.out.printf("Bill: %.2f\n",customer.getBill());
                });

        System.out.printf("Total bill: %.2f", totalBill);
    }

    static int returnIndex(List<Customer> customers, String name){

        for (int i = 0; i < customers.size(); i++) {
             if(customers.get(i).getName().equals(name)){
                 return i;
             }
        }
        return 0;
    }


//    static boolean checIsInList(List<Customer> customers, String name){
//        for (Customer customer : customers) {
//            if(customer.getName().equals(name)){
//                return  false;
//            }
//        }
//        return true;
//    }

    static class Customer {
        public String name;
        public LinkedHashMap<String,Integer> shoplist;
        double bill = 0;

        public Customer (String name){
            this.name = name;
            this.shoplist = new LinkedHashMap<>();
        }

        public void setBill (double bill){
            this.bill += bill;
        }

        public double getBill() {
            return bill;
        }

        public String getName() {
            return name;
        }
    }
}
