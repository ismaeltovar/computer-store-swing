// All Store.java code except the BufferedReader constructor and the save method where 
// created by Professor George F. Rice licensed under GPL v3.0
// Link to license: https://github.com/prof-rice/cse1325-prof/blob/main/LICENSE

package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Store {
    // ///////////////////////////////////////////////////////////
    // Fields
    
    private String name;
    private TreeSet<Customer> customers;
    private HashSet<Option> options;
    private HashSet<Computer> computers;
    private HashSet<Order> orders;
    
    public Store(String name) {
        this.name = name;
        customers = new TreeSet<>();
        options = new HashSet<>();
        computers = new HashSet<>();
        orders = new HashSet<>();
    }

    public Store(BufferedReader br) throws IOException {
        name = br.readLine();

        //customers
        customers = new TreeSet<>();
        int cmNum = Integer.parseInt(br.readLine());
        while (cmNum-- > 0) {
            customers.add(new Customer(br));
        }

        //options
        options = new HashSet<>();
        int opNum = Integer.parseInt(br.readLine());
        while (opNum-- > 0) {
            options.add(new Option(br));
        }

        //computers
        computers = new HashSet<>();
        int cpNum = Integer.parseInt(br.readLine());
        while (cpNum-- > 0) {
            computers.add(new Computer(br));
        }
        
        //orders
        orders = new HashSet<>();
        int orNum = Integer.parseInt(br.readLine());
        while (orNum-- > 0) {
            orders.add(new Order(br));
        }
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        
        //customers
        save(bw, customers);

        //options
        save(bw, options);

        //computers
        save(bw, computers);

        //orders
        save(bw, orders);
    }

    private <T extends Saveable> void save(BufferedWriter bw, Set<T> set) throws IOException {
        bw.write(set.size() + "\n");

        for (var obj : set) {
            obj.save(bw);
        }
    }

    public String name() {
        return this.name;
    }
    
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }
}
