package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements Saveable, Comparable<Customer> {
    private String name;
    private String email;

    public Customer(String name, String email) {
        int at_indx = email.indexOf('@');
        if (at_indx < 0) {
            throw new IllegalArgumentException("No @ symbol found in " + email);
        }

        String str_after_at = email.substring(at_indx + 1, email.length());
        int dot_indx = str_after_at.indexOf('.');
        if (dot_indx < 0) {
            throw new IllegalArgumentException("No . symbol in " + email);
        }

        this.name = name;
        this.email = email;
    }

    public Customer(BufferedReader br) throws IOException {
        name = br.readLine();
        email = br.readLine();
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(email + "\n");
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
        } catch (Exception e) {
            return false;
        }
        
        Customer c = (Customer)o;
        return c.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        int hash = 0;

        for (int i = 0; i < name.length(); i++)
            hash += name.charAt(i);

        for (int i = 0; i < email.length(); i++)
            hash += email.charAt(i);

        return hash;
    }

    @Override
    public int compareTo(Customer cm) {
        String pcmName = "";
        String pcmEmail = "";

        //Customer parameter regex
        Pattern pattern = Pattern.compile("([\\s\\S]*)[ ]+\\(([\\s\\S]*)\\)");
        Matcher m = pattern.matcher(cm.toString());

        if (m.matches()) {
            pcmName = m.group(1);
            pcmEmail = m.group(2);
        }

        //Compare names
        int nameCMP = this.name.compareToIgnoreCase(pcmName);

        if (nameCMP != 0)
            return nameCMP;
        
        //Compare emails
        int emailCMP = this.email.compareToIgnoreCase(pcmEmail);
        System.out.println(emailCMP);
        
        return emailCMP;
    }
}
