package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Order implements Saveable {
    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers;

    public Order(Customer customer) {
        this.customer = customer;
        computers = new ArrayList<>();
        orderNumber = nextOrderNumber++;
    }

    public Order(BufferedReader br) throws IOException {
        orderNumber = Long.parseLong(br.readLine());
        customer = new Customer(br);

        computers = new ArrayList<>();
        int cpNum = Integer.parseInt(br.readLine());
        while (cpNum-- > 0) {
            computers.add(new Computer(br));
        }

        nextOrderNumber++;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(orderNumber + "\n");
        customer.save(bw);

        bw.write(computers.size() + "\n");
        for (Computer cp : computers) {
            cp.save(bw);
        }
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
        //sorts array every time new computer is added for comparison
        Collections.sort(computers);
    }

    public long cost() {
        long sum = 0;
        for (Computer cp : computers)
            sum += cp.cost();
        return sum;
    }

    @Override
    public String toString() {
        String str = "Order " + orderNumber + " for " + customer.toString() + 
        " $" + this.cost() / 100 + "." + this.cost() % 100 + "\n\n";

        for (Computer cp : computers) {
            str += cp.toString() + "\n";
        }

        return str;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof Order)) return false;
        } catch (Exception e) {
            return false;
        }

        Order ord = (Order)o;
        String oStr = ord.toString();
        //Removes Order # from string to allow for appropriate comparison
        String oCmpStr = oStr.substring(0, oStr.indexOf('f'));
        String thisStr = this.toString();
        String thisCmpStr = thisStr.substring(0, thisStr.indexOf('f'));

        boolean isEqual = oCmpStr.equals(thisCmpStr);
        return isEqual;
    }

    @Override
    public int hashCode() {
        int hash = (int)nextOrderNumber + (int)orderNumber + customer.hashCode();
        
        for (Computer cm : computers) {
            hash += cm.hashCode();
        }

        return hash;
    }
}
