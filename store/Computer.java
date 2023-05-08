package store;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.Comparable;

public class Computer implements Saveable, Comparable<Computer>{
    private String name;
    private String model;
    private ArrayList<Option> options;

    public Computer(String name, String model) {
        this.name = name;
        this.model = model;
        options = new ArrayList<Option>();
    }

    public Computer(BufferedReader br) throws IOException {
        name = br.readLine();
        model = br.readLine();

        options = new ArrayList<>();
        int opNum = Integer.parseInt(br.readLine());
        while (opNum-- > 0) {
            options.add(new Option(br));
        }
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(model + "\n");

        bw.write(options.size() + "\n");
        for (Option op : options) {
            op.save(bw);
        }
    }

    public void addOption(Option option) {
        options.add(option);
        //sorts array every time new item is added for comparison
        Collections.sort(options);
    }

    public long cost() {
        long sum = 0;
        for (Option op : options) {
            sum += op.cost();
        }

        return sum;
    }

    @Override
    public String toString() {
        String str = name + " (" + model + ")\n";

        for (Option op : options) {
            str += op.toString() + "\n";
        }

        return str;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof Computer)) return false;
        } catch (Exception e) {
            return false;
        }

        Computer c = (Computer)o;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i);
        }

        for (int i = 0; i < model.length(); i++) {
            hash += model.charAt(i);
        }

        for (Option op : options) {
            hash += op.hashCode();
        }
        return hash;
    }

    @Override
    public int compareTo(Computer c) {
        return (int)(this.cost() - c.cost());
    }
}
