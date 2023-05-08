package gui;

import store.Store;
import store.Customer;
import store.Option;
import store.Order;
import store.Computer;
import javax.swing.JLabel;

import java.awt.FlowLayout;

/** Custom class that extends JLabel. 
 * Used to easily update the display when new data gets inserted.
 * 
 * @param store      Current state of store, used to display the current data
 */
public class DataDisplay extends JLabel {
    private JLabel computersLbl; //Stores Computer Data to display
    private JLabel optionsLbl; //Stores Options Data to display
    private JLabel customersLbl; //Stores Customers Data to display
    private JLabel ordersLbl; //Stores Orders Data to display

    public DataDisplay(Store store) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        setVerticalAlignment(JLabel.TOP);
        
        //Customers Data
        customersLbl = new JLabel();
        String cmTxt = "<html>";
        cmTxt += "<div>" 
        + "<h3 style=\"text-align: center;\">Customers</h3>"
        + "<ol>";
        for (Object o : store.customers()) {
            cmTxt += "<li>";
            cmTxt += ((Customer)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            cmTxt += "</li>";
        }
        cmTxt += "</ol> </div> </html>";
        customersLbl.setText(cmTxt);
        add(customersLbl);
        
        //Options Data
        optionsLbl = new JLabel();
        String opTxt = "<html>";
        opTxt += "<div>" 
        + "<h3 style=\"text-align: center;\">Options</h3>"
        + "<ol>";
        for (Object o : store.options()) {
            opTxt += "<li>";
            opTxt += ((Option)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            opTxt += "</li>";
        }
        opTxt += "</ol> </div> </html>";
        optionsLbl.setText(opTxt);
        add(optionsLbl);
        
        //Computers Data
        computersLbl = new JLabel();
        String cpTxt = "<html>";
        cpTxt += "<div>"
        + "<h3 style=\"text-align: center;\">Computers</h3>"
        + "<ol>";
        for (Object o : store.computers()) {
            cpTxt += "<li>";
            cpTxt += ((Computer)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            cpTxt += "</li>";
        }
        cpTxt += "</ol> </div> </html>";
        computersLbl.setText(cpTxt);
        add(computersLbl);
        
        //Orders Data
        ordersLbl = new JLabel();
        String orTxt = "<html>";
        orTxt += "<div>"
        + "<h3 style=\"text-align: center;\">Orders</h3>"
        + "<ol>";
        for (Object o : store.orders()) {
            orTxt += "<li>";
            orTxt += ((Order)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            orTxt += "</li>";
        }
        orTxt += "</ol> </div> </html>";
        ordersLbl.setText(orTxt);
        add(ordersLbl);
    }

    /** Updates DataDisplay JLabel with new data
     * 
     * @param store     Current state of store
     */
    public void updateDisplay(Store store) {
        //Update Customers Data
        String cmTxt = "<html>";
        cmTxt += "<div>" 
        + "<h3 style=\"text-align: center;\">Customers</h3>"
        + "<ol>";
        for (Object o : store.customers()) {
            cmTxt += "<li>";
            cmTxt += ((Customer)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            cmTxt += "</li>";
        }
        cmTxt += "</ol> </div> </html>";
        customersLbl.setText(cmTxt);
        
        //Update Options Data
        String opTxt = "<html>";
        opTxt += "<div>" 
        + "<h3 style=\"text-align: center;\">Options</h3>"
        + "<ol>";
        for (Object o : store.options()) {
            opTxt += "<li>";
            opTxt += ((Option)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            opTxt += "</li>";
        }
        opTxt += "</ol> </div> </html>";
        optionsLbl.setText(opTxt);
        
        //Update Computers Data
        String cpTxt = "<html>";
        cpTxt += "<div>"
        + "<h3 style=\"text-align: center;\">Computers</h3>"
        + "<ol>";
        for (Object o : store.computers()) {
            cpTxt += "<li>";
            cpTxt += ((Computer)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            cpTxt += "</li>";
        }
        cpTxt += "</ol> </div> </html>";
        computersLbl.setText(cpTxt);

        //Update Orders Data
        String orTxt = "<html>";
        orTxt += "<div>"
        + "<h3 style=\"text-align: center;\">Orders</h3>"
        + "<ol>";
        for (Object o : store.orders()) {
            orTxt += "<li>";
            orTxt += ((Order)o).toString()
            .replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>");
            orTxt += "</li>";
        }
        orTxt += "</ol> </div> </html>";
        ordersLbl.setText(orTxt);
    }

    /** Sets display JLabel to display only the specified record type
     * 
     * @param record    Specified record type to display
     */
    public void setView(Record record) {
        switch (record) {
            case COMPUTER -> {showComputersDisplay();}
            case OPTION -> {showOptionsDisplay();}
            case CUSTOMER -> {showCustomersDisplay();}
            case ORDER -> {showOrdersDisplay();}
        }
    }

    /** Updates display to show Computers & hide all other data
     */
    public void showComputersDisplay() {
        if (!computersLbl.isVisible()) {
            computersLbl.setVisible(true);
        }

        customersLbl.setVisible(false);
        optionsLbl.setVisible(false);
        ordersLbl.setVisible(false);
    }

    /** Updates display to show Options & hide all other data
     */
    public void showOptionsDisplay() {
        if (!optionsLbl.isVisible()) {
            optionsLbl.setVisible(true);
        }

        computersLbl.setVisible(false);
        customersLbl.setVisible(false);
        ordersLbl.setVisible(false);
    }
    
    /** Updates display to show Customers & hide all other data
     */
    public void showCustomersDisplay() {
        if (!customersLbl.isVisible()) {
            customersLbl.setVisible(true);
        }

        computersLbl.setVisible(false);
        optionsLbl.setVisible(false);
        ordersLbl.setVisible(false);
    }

    /** Updates diplay to show Orders & hide all other data 
    */
    public void showOrdersDisplay() {
        if (!ordersLbl.isVisible()) {
            ordersLbl.setVisible(true);
        }
        
        computersLbl.setVisible(false);
        optionsLbl.setVisible(false);
        customersLbl.setVisible(false);
    }
}
