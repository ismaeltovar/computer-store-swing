package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
//NOTE: that the cost is in cents
import java.lang.Comparable;

public class Option implements Saveable, Comparable<Option> {
    protected String name;
    protected long cost;

    public Option(String name, long cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Invalid negative cost " + cost);
        }

        this.name = name;
        this.cost = cost;
    }

    public Option(BufferedReader br) throws IOException {
        name = br.readLine();
        cost = Long.parseLong(br.readLine());
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(cost + "\n");
    }

    public long cost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " ($" + (cost / 100) + "." + (cost % 100) + ")";
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof Option)) return false;
        } catch (Exception e) {
            return false;
        }

        Option op = (Option)o;
        return this.toString().equals(op.toString());
    }

    @Override
    public int hashCode() {
        int hash = (int)cost;

        for (int i = 0; i < name.length(); i++)
            hash += name.charAt(i);

        return hash;
    }

    @Override
    public int compareTo(Option o) {
        return (int)(this.cost - o.cost());
    }
}
