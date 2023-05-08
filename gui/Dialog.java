package gui;

import store.Option;
import store.Order;
import store.Store;
import store.Computer;
import store.Customer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import java.awt.event.ActionListener;

/** Custom Dialog class that extends JDialog. Used to generate dialogs depending on record type.
 * 
 * @param frame     JFrame from MainWin class
 * @param title     Name of the Dialog
 */
public class Dialog extends JDialog {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField costField;
    private JTextField modelField;

    private ArrayList<Object> selectedOps;
    private ArrayList<Object> selectedComps;
    private Object selectedCustomer;
    private int orderComps;

    private final GridBagConstraints dConstr;
    private final int dWidth = 520;  //default width of dialog
    private final int dHeight = 145; //default height of dialog

    public Dialog(JFrame frame, String title) {
        super(frame, title);
        dConstr = constraints(0, 0, 1, 1);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    /**
     * Custom constraints method used to generate constraints for each component of JDialog
     * Used to avoid repetitiveness when adding to JDialog
     * 
     * @param gridx         gridx property for GridBagConstraints
     * @param gridy         gridy property for GridBagConstraints
     * @param gridwidth     gridwidth property for GridBagConstraints
     * @param gridheight    gridheight property for GridBagConstraints
     */
    private GridBagConstraints constraints(int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = gridx;
        constr.gridy = gridy;
        constr.gridwidth = gridwidth;
        constr.gridheight = gridheight;
        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;

        return constr;
    }

    /** Generates & displays dialog to add a Customer & updates nameField & emailField accordingly
     * 
     * @param okLis         Listener for the ok button
     * @param cancelLis     Listener for the cancel button
     */
    public final void showCustomerDialog(ActionListener okLis, ActionListener cancelLis) {
        setDefaultLayout();

        //ImageIcon
        ImageIcon icon = new ImageIcon("gui/resources/icons-64/add-customer-64.png");
        JLabel iconLbl = new JLabel(icon);
        iconLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints iconConstr = (GridBagConstraints) dConstr.clone();
        iconConstr.gridheight = 3;
        add(iconLbl, iconConstr);

        JLabel nameLbl = new JLabel("Customer name:");
        GridBagConstraints nameLblConstr = (GridBagConstraints)dConstr.clone();
        nameLblConstr.gridx = 2;
        nameLblConstr.gridy = 1;
        add(nameLbl, nameLblConstr);
        
        nameField = new JTextField("Customer name:", 25);
        GridBagConstraints nameFieldConstr = (GridBagConstraints)dConstr.clone();
        nameFieldConstr.gridx = 3;
        nameFieldConstr.gridy = 1;
        nameField.setText("John Smith");
        add(nameField, nameFieldConstr);
        
        JLabel emailLbl = new JLabel("Customer email:");
        GridBagConstraints emailLblConstr = (GridBagConstraints)dConstr.clone();
        emailLblConstr.gridx = 2;
        emailLblConstr.gridy = 2;
        add(emailLbl, emailLblConstr);
        
        emailField = new JTextField("Customer email:", 25);
        GridBagConstraints emailFieldConstr = (GridBagConstraints)dConstr.clone();
        emailFieldConstr.gridx = 3;
        emailFieldConstr.gridy = 2;
        emailField.setText("john@smith.com");
        add(emailField, emailFieldConstr);

        JPanel panel = new JPanel();
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(okLis);
        panel.add(okBtn);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(cancelLis);
        panel.add(cancelBtn);
        
        GridBagConstraints panelConstr = (GridBagConstraints) dConstr.clone();
        panelConstr.gridy = 3;
        panelConstr.gridwidth = 5;
        add(panel, panelConstr);
        setVisible(true);
    }

    /** Generates & displays dialog to add an Option. Updates nameField & costField accordingly
     * 
     * @param okLis         Listener for the ok button
     * @param cancelLis     Listener for the cancel button
     */
    public final void showOptionDialog(ActionListener okLis, ActionListener cancelLis) {
        setDefaultLayout();

        //ImageIcon
        ImageIcon icon = new ImageIcon("gui/resources/icons-64/add-option-64.png");
        JLabel iconLbl = new JLabel(icon);
        iconLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints iconConstr = (GridBagConstraints) dConstr.clone();
        iconConstr.gridheight = 3;
        add(iconLbl, iconConstr);

        JLabel nameLbl = new JLabel("Option Name:");
        GridBagConstraints nameLblConstr = (GridBagConstraints)dConstr.clone();
        nameLblConstr.gridx = 2;
        nameLblConstr.gridy = 1;
        add(nameLbl, nameLblConstr);
        
        nameField = new JTextField(25);
        GridBagConstraints nameFieldConstr = (GridBagConstraints)dConstr.clone();
        nameFieldConstr.gridx = 3;
        nameFieldConstr.gridy = 1;
        nameField.setText("CPU 1234987345");
        add(nameField, nameFieldConstr);
        
        JLabel costLbl = new JLabel("Option Cost($):");
        GridBagConstraints costLblConstr = (GridBagConstraints)dConstr.clone();
        costLblConstr.gridx = 2;
        costLblConstr.gridy = 2;
        add(costLbl, costLblConstr);
        
        costField = new JTextField(25);
        GridBagConstraints costFieldConstr = (GridBagConstraints)dConstr.clone();
        costFieldConstr.gridx = 3;
        costFieldConstr.gridy = 2;
        costField.setText("1000.99");
        add(costField, costFieldConstr);
        
        JPanel panel = new JPanel();
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(okLis);
        panel.add(okBtn);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(cancelLis);
        panel.add(cancelBtn);
        
        GridBagConstraints panelConstr = (GridBagConstraints) dConstr.clone();
        panelConstr.gridy = 3;
        panelConstr.gridwidth = 5;
        add(panel, panelConstr);
        setVisible(true);
    }

    /** Generates & displays dialog to add a Computer. Updates nameField, modelField, and selectedOps accordingly
     * 
     * @param okLis         Listener for the ok button
     * @param cancelLis     Listener for the cancel button
     * @param options       The current available Options in store
     */
    public final void showComputerDialog(ActionListener okLis, ActionListener cancelLis, Object[] options) {
        setDefaultLayout();
        setSize(dWidth + 50, dHeight);

        //ImageIcon
        ImageIcon icon = new ImageIcon("gui/resources/icons-64/add-computer-64.png");
        JLabel iconLbl = new JLabel(icon);
        iconLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints iconConstr = (GridBagConstraints) dConstr.clone();
        iconConstr.gridheight = 3;
        add(iconLbl, iconConstr);

        selectedOps = new ArrayList<>();
        boolean noOptions = options.length == 0;
    
        String[] strOps = new String[options.length == 0 ? 1 : options.length];
    
        if (noOptions) {
            strOps[0] = "No Options Available.";
        } else {
            for (int i = 0; i < options.length; i++) {
                strOps[i] = ((Option)options[i]).toString();
            }
        }

        JLabel nameLbl = new JLabel("Computer name:");
        GridBagConstraints nameLblConstr = (GridBagConstraints)dConstr.clone();
        nameLblConstr.gridx = 2;
        add(nameLbl, nameLblConstr);
        
        nameField = new JTextField(25);
        nameField.setPreferredSize(new Dimension(dWidth - 20, dHeight - 20));
        GridBagConstraints nameFieldConstr = (GridBagConstraints)dConstr.clone();
        nameFieldConstr.gridx = 3;
        nameField.setText("Laptop 9000");
        add(nameField, nameFieldConstr);
        
        JLabel modelLbl = new JLabel("Computer model:");
        GridBagConstraints modelLblConstr = (GridBagConstraints)dConstr.clone();
        modelLblConstr.gridx = 2;
        modelLblConstr.gridy = 1;
        add(modelLbl, modelLblConstr);
        
        modelField = new JTextField(25);
        modelField.setPreferredSize(new Dimension(dWidth - 20, dHeight - 20));
        GridBagConstraints modelFieldConstr = (GridBagConstraints)dConstr.clone();
        modelFieldConstr.gridx = 3;
        modelFieldConstr.gridy = 1;
        modelField.setText("GX-1010");
        add(modelField, modelFieldConstr);
        
        JLabel opLbl = new JLabel("Option:", SwingConstants.RIGHT);
        GridBagConstraints opLblConstr = (GridBagConstraints)dConstr.clone();
        opLblConstr.gridx = 2;
        opLblConstr.gridy = 2;
        add(opLbl, opLblConstr);
        
        JComboBox<String> opField = new JComboBox<String>(strOps);
        opField.setPrototypeDisplayValue("---------------------");
        opField.setPreferredSize(new Dimension(dWidth, dHeight));
        GridBagConstraints opFieldConstr = (GridBagConstraints)dConstr.clone();
        opFieldConstr.gridx = 3;
        opFieldConstr.gridy = 2;
        add(opField, opFieldConstr);
        
        JButton addBtn = new JButton("Add");
        addBtn.setEnabled(!noOptions);
        addBtn.addActionListener(event -> { selectedOps.add(options[opField.getSelectedIndex()]); });
        GridBagConstraints addBtnConstr = (GridBagConstraints)dConstr.clone();
        addBtnConstr.gridx = 4;
        addBtnConstr.gridy = 2;
        addBtnConstr.fill = GridBagConstraints.HORIZONTAL;
        addBtnConstr.anchor = GridBagConstraints.CENTER;
        add(addBtn, addBtnConstr);

        JPanel btnPanel = new JPanel();
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(okLis);
        btnPanel.add(okBtn);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(cancelLis);
        btnPanel.add(cancelBtn);
        
        GridBagConstraints btnPanelConstr = (GridBagConstraints) dConstr.clone();
        btnPanelConstr.gridy = 3;
        btnPanelConstr.gridwidth = 5;
        add(btnPanel, btnPanelConstr);
        setVisible(true);
    }

    /** Generates & displays first dialog to add a Order.
     * 
     * @param cmObj         Selected Customer for use in okLis
     * @param display       DataDisplay object to update
     * @param store         The current store state
     */
    public void showOrderDialog(Object cmObj, DataDisplay display, Store store) {
        GridBagLayout cLayout = new GridBagLayout();
        cLayout.columnWidths = new int[]{75, 160};
        cLayout.rowHeights = new int[]{190, 35, 45};
        setLayout(cLayout);
        setSize(dWidth, 280);

        Order newOr = new Order((Customer)cmObj);
        orderComps = 0;
        selectedCustomer = null;
        selectedComps = new ArrayList<>();

        //Order display
        JTextArea orDisplay = new JTextArea();
        orDisplay.setText(newOr.toString());
        orDisplay.setLineWrap(true);
        orDisplay.setEditable(false);
        orDisplay.setBackground(getBackground());

        JScrollPane scrollArea = new JScrollPane(orDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollArea.setPreferredSize(new Dimension(dWidth, dHeight));
        GridBagConstraints orDisplayConstr = (GridBagConstraints) dConstr.clone();
        orDisplayConstr.gridwidth = 2;
        orDisplayConstr.gridheight = 1;
        orDisplayConstr.fill = GridBagConstraints.BOTH;
        add(scrollArea, orDisplayConstr);

        //Top computer ComboBox
        JLabel cpLbl = new JLabel("Computer: ");
        GridBagConstraints cpLblConstr = (GridBagConstraints)dConstr.clone();
        cpLblConstr.gridy = 1;
        add(cpLbl, cpLblConstr);
        
        boolean noComp = store.computers().length == 0;
        JComboBox<Object> cpBox = new JComboBox<>(store.computers());
        cpBox.setPrototypeDisplayValue("----------------------------------------------------------");
        if (noComp) {
            cpBox.addItem(new Computer("No Computers Available.", ""));
        }
        GridBagConstraints cpBoxConstr = (GridBagConstraints)dConstr.clone();
        cpBoxConstr.gridx = 1;
        cpBoxConstr.gridy = 1;
        cpBoxConstr.fill = GridBagConstraints.HORIZONTAL;
        add(cpBox, cpBoxConstr);
    
        //bottom button panel
        JPanel btnPanel = new JPanel();
        
        //Only added if there are computers available to add to the order
        if (!noComp) {
            JButton addBtn = new JButton("Add");
            addBtn.addActionListener(event -> {
                newOr.addComputer((Computer)cpBox.getSelectedItem());
                orDisplay.setText(newOr.toString());
                orDisplay.revalidate();
                repaint();
                orderComps++;
            });
            btnPanel.add(addBtn, BorderLayout.CENTER);

            JButton finishBtn = new JButton("Finish");
            finishBtn.addActionListener(event -> {
                if (orderComps > 0) {
                    store.add(newOr);
                }
                this.clear();
                display.updateDisplay(store);
                display.setView(Record.ORDER);
            });
            btnPanel.add(finishBtn, BorderLayout.CENTER);
        }

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(event -> this.clear());
        btnPanel.add(cancelBtn, BorderLayout.CENTER);
        
        GridBagConstraints btnPanelConstr = (GridBagConstraints)dConstr.clone();
        btnPanelConstr.gridy = 2;
        btnPanelConstr.gridwidth = 3;
        add(btnPanel, btnPanelConstr);
        
        setVisible(true);
    }

    /** Sets JDialog to default layout.
     * 
     * <ul>
     * <li>cLayout.columWidths = {140, 10, 75, 180, 30}</li>
     * <li>cLayout.rowHeights = {25, 25, 25, 35}</li>
     * </ul>
     */
    public void setDefaultLayout() {
        GridBagLayout cLayout = new GridBagLayout();
        cLayout.columnWidths = new int[]{140, 10, 75, 180, 30};
        cLayout.rowHeights = new int[]{25, 25, 25, 35};
        setLayout(cLayout);
        setSize(dWidth, dHeight);
    }

    /** Disposes & hides the dialog
     */
    public void clear() {
        setVisible(false);
        dispose();
    }

    /**
     * @return value of nameField
     */
    public String name() {
        return nameField.getText();
    }
    /**
     * @return value of emailField
     */
    public String email() {
        return emailField.getText();
    }
    
    /**
     * @return value of modelField
     */
    public String model() {
        return modelField.getText();
    }

    /**
     * @return value of costField
     */
    public long cost() {
        String inStr = costField.getText(); 
        return (long)(Double.parseDouble(inStr) * 100);
    }

    /**
     * @return selected options in JComboBox in {@link gui.Dialog#showNextComputerDialog}
     */
    public Object[] selectedOps() {
        return selectedOps.toArray();
    }

    /**
     * @return selected computers in JComboBox in {@link gui.Dialog#showNextOrderDialog}
     */
    public Object[] selectedComps() {
        return selectedComps.toArray();
    }

    /**
     * @return selected customer in {@link gui.Dialog#showStartOrderDialog}
     */
    public Object selectedCustomer() {
        return selectedCustomer;
    }
}
