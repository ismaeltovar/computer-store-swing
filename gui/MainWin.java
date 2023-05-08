package gui;

import store.Customer;
import store.Computer;
import store.Option;
import store.Store;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainWin extends JFrame {
    private Store store;
    private DataDisplay display; //DataDisplay is custom class that extends JLabel
    private File saveFile;

    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 800);

        saveFile = new File("data.elsa");

        //-----------JMenuBar
        JMenuBar mBar = new JMenuBar();
        
        //File menu
        JMenu file = new JMenu("File");
        JMenuItem nw = new JMenuItem("New"); 
        JMenuItem open = new JMenuItem("Open"); 
        JMenuItem save = new JMenuItem("Save"); 
        JMenuItem saveAs = new JMenuItem("Save As"); 
        JMenuItem quit = new JMenuItem("Quit");
        nw.addActionListener(event -> onNewClick());
        open.addActionListener(event -> onOpenClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        quit.addActionListener(event -> onQuitClick());
        file.add(nw);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);
        
        //Insert menu
        JMenu insert = new JMenu("Insert");
        JMenuItem customer = new JMenuItem("Customer");
        customer.addActionListener(event -> onInsertCustomerClick());
        JMenuItem option = new JMenuItem("Option");
        option.addActionListener(event -> {onInsertOptionClick();});
        JMenuItem comp = new JMenuItem("Computer");
        comp.addActionListener(event -> {onInsertComputerClick();});
        JMenuItem order = new JMenuItem("Order");
        order.addActionListener(event -> {onInsertOrderClick();});
        insert.add(customer);
        insert.add(option);
        insert.add(comp); 
        insert.add(order);
        
        //View menu
        JMenu view = new JMenu("View");
        JMenuItem customers = new JMenuItem("Customers");
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        JMenuItem options = new JMenuItem("Options");
        options.addActionListener(event -> onViewClick(Record.OPTION));
        JMenuItem comps = new JMenuItem("Computers");
        comps.addActionListener(event -> onViewClick(Record.COMPUTER));
        JMenuItem orders = new JMenuItem("Orders");
        orders.addActionListener(event -> onViewClick(Record.ORDER));
        view.add(customers);
        view.add(options);
        view.add(comps);
        view.add(orders);
        
        //Help menu
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(event -> onAboutClick());
        help.add(about);

        mBar.add(file);
        mBar.add(insert);
        mBar.add(view);
        mBar.add(help);
        setJMenuBar(mBar);
        
        //-------------ToolBar
        JToolBar toolbar = new JToolBar("ELSA controls");
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));
        toolbar.setFloatable(false);
        
        JPanel topPnl = new JPanel();
        
        //--First set of buttons (File buttons)
        JPanel btnPnl1 = new JPanel();
        btnPnl1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //New
        JButton newBtn = new JButton(new ImageIcon("gui/resources/icons-64/new-64.png"));
        newBtn.setSize(32, 32);
        newBtn.setActionCommand("New");
        newBtn.setToolTipText("New");
        newBtn.addActionListener(event -> onNewClick());
        btnPnl1.add(newBtn);
        
        //Open
        JButton openBtn = new JButton(new ImageIcon("gui/resources/icons-64/open-64.png"));
        openBtn.setActionCommand("Open");
        openBtn.setToolTipText("Open");
        openBtn.addActionListener(event -> onOpenClick());
        btnPnl1.add(openBtn);
        btnPnl1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Save
        JButton saveBtn = new JButton(new ImageIcon("gui/resources/icons-64/save-64.png"));
        saveBtn.setActionCommand("Save");
        saveBtn.setToolTipText("Save");
        saveBtn.addActionListener(event -> onSaveClick());
        btnPnl1.add(saveBtn);
        
        //Save As
        JButton saveAsBtn = new JButton(new ImageIcon("gui/resources/icons-64/save-as-64.png"));
        saveAsBtn.setActionCommand("Save As");
        saveAsBtn.setToolTipText("Save As");
        saveAsBtn.addActionListener(event -> onSaveAsClick());
        btnPnl1.add(saveAsBtn);

        topPnl.add(btnPnl1);
        
        JPanel btmPnl = new JPanel();

        //---Second set of buttons (Add buttons)
        JPanel btnPnl2 = new JPanel();
        btnPnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Add Customer
        JButton addCM = new JButton(new ImageIcon("gui/resources/icons-64/add-customer-64.png"));
        addCM.setActionCommand("Add Customer");
        addCM.setToolTipText("Add Customer");
        addCM.addActionListener(event -> onInsertCustomerClick());
        btnPnl2.add(addCM);
        
        //Add Option
        JButton addOP = new JButton(new ImageIcon("gui/resources/icons-64/add-option-64.png"));
        addOP.setActionCommand("Add Option");
        addOP.setToolTipText("Add Option");
        addOP.addActionListener(event -> onInsertOptionClick());
        btnPnl2.add(addOP);
        
        //Add Computer
        JButton addCP = new JButton(new ImageIcon("gui/resources/icons-64/add-computer-64.png"));
        addCP.setOpaque(true);
        addCP.setActionCommand("Add Computer");
        addCP.setToolTipText("Add Computer");
        addCP.addActionListener(event -> onInsertComputerClick());
        btnPnl2.add(addCP);

        //Add Order
        JButton addOr = new JButton(new ImageIcon("gui/resources/icons-64/add-order-64.png"));
        addOr.setOpaque(true);
        addOr.setActionCommand("Add Order");
        addOr.setToolTipText("Add Order");
        addOr.addActionListener(event -> onInsertOrderClick());
        btnPnl2.add(addOr);
        
        //---Third set of buttons (View buttons)
        JPanel btnPnl3 = new JPanel();
        btnPnl3.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //View Customers
        JButton viewCM = new JButton(new ImageIcon("gui/resources/icons-64/view-customers-64.png"));
        viewCM.setActionCommand("View Customer");
        viewCM.setToolTipText("View Customer");
        viewCM.addActionListener(event -> onViewClick(Record.CUSTOMER));
        btnPnl3.add(viewCM);
        
        //View Options
        JButton viewOP = new JButton(new ImageIcon("gui/resources/icons-64/view-options-64.png"));
        viewOP.setActionCommand("View Options");
        viewOP.setToolTipText("View Options");
        viewOP.addActionListener(event -> onViewClick(Record.OPTION));
        btnPnl3.add(viewOP);
        
        //View Computers
        JButton viewCP = new JButton(new ImageIcon("gui/resources/icons-64/view-computers-64.png"));
        viewCP.setActionCommand("View Computers");
        viewCP.setToolTipText("View Computers");
        viewCP.addActionListener(event -> onViewClick(Record.COMPUTER));
        btnPnl3.add(viewCP);

        //View Orders
        JButton viewOr = new JButton(new ImageIcon("gui/resources/icons-64/view-orders-64.png"));
        viewOr.setActionCommand("View Orders");
        viewOr.setToolTipText("View Orders");
        viewOr.addActionListener(event -> onViewClick(Record.ORDER));
        btnPnl3.add(viewOr);

        btmPnl.add(btnPnl2);
        btmPnl.add(btnPnl3);

        topPnl.setBackground(Color.lightGray);
        toolbar.add(topPnl);
        // toolbar.addSeparator();
        btmPnl.setBackground(Color.lightGray);
        toolbar.add(btmPnl);
        // toolbar.addSeparator();

        add(toolbar, BorderLayout.PAGE_START);
        
        //------------Display
        this.store = new Store("ELSA");
        display = new DataDisplay(this.store);
       
        add(display, BorderLayout.CENTER);
        setVisible(true);
    }

    protected void onNewClick() {
        String name = "";
        try {
            name = JOptionPane.showInputDialog(this, "New Store name: ", "New Store", JOptionPane.QUESTION_MESSAGE);

            int confirm = JOptionPane.YES_OPTION;
            if (name.equals("")) {
                confirm = JOptionPane.showConfirmDialog(this, "Empty Store Name set. Do you wish to continue?" + name, "Input Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            } 
            
            if (name != null && confirm == JOptionPane.YES_OPTION) {
                this.store = new Store(name);
                display.updateDisplay(this.store);
            } 
        } catch (Exception e) {
            if (name != null) {
                JOptionPane.showMessageDialog(this, "Invalid Store Name:\n" + name, "Input Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Failed to read input data in JOptionPane: " + e.getMessage());
            }
        }
    }

    protected void onOpenClick() {
        final JFileChooser fc = new JFileChooser(saveFile);
        FileFilter elsaFiles = new FileNameExtensionFilter("ELSA files", "elsa");
        fc.addChoosableFileFilter(elsaFiles);
        fc.setFileFilter(elsaFiles);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            saveFile = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(saveFile.getName()))) {
                this.store = new Store(br);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Could not load file: " + e.getMessage(), "Load Error", JOptionPane.ERROR_MESSAGE);
            }

            display.updateDisplay(this.store);
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile.getName()));) {
            this.store.save(bw);
        } catch (Exception e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(saveFile);
        FileNameExtensionFilter elsaFiles = new FileNameExtensionFilter("ELSA files", "elsa");
        fc.addChoosableFileFilter(elsaFiles);
        fc.setFileFilter(elsaFiles);
        fc.setSelectedFile(saveFile);

        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            saveFile = fc.getSelectedFile();
            if (!saveFile.getAbsolutePath().endsWith(".elsa")) {
                saveFile = new File(saveFile.getAbsolutePath() + ".elsa");
            }

            onSaveClick();
        }
    }
    
    protected void onQuitClick() {
        System.exit(ABORT);
    }

    protected void onInsertCustomerClick() {
        Dialog cmDialog = new Dialog(this, "New Customer");
        cmDialog.showCustomerDialog(
            event -> { 
                try {
                    this.store.add(new Customer(cmDialog.name(), cmDialog.email())); 
                    cmDialog.clear();
                    display.updateDisplay(this.store);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Invalid email:\n" + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            },
            event -> { cmDialog.clear(); }
        );        
    }
    
    /** Alternative method when called from {@link #onInsertOrderClick() onInsertOrderClick}
     * 
     * @param orderInsert   Whether method is being called from onInsertOrderClick() method
     */
    protected void onInsertCustomerClick(boolean orderInsert) {
        Dialog cmDialog = new Dialog(this, "New Customer");
        cmDialog.showCustomerDialog(
            event -> { 
                try {
                    this.store.add(new Customer(cmDialog.name(), cmDialog.email())); 
                    cmDialog.clear();
                    display.updateDisplay(this.store);
                    if (orderInsert)
                        this.onInsertOrderClick();
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Invalid email:\n" + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            },
            event -> { cmDialog.clear(); }
        );        
    }
    
    protected void onInsertOptionClick() {
        Dialog opDialog = new Dialog(this, "New Option");
        opDialog.showOptionDialog(
            event -> {
                try {
                    Option op = new Option(opDialog.name(), opDialog.cost());
                    this.store.add(op); 
                    opDialog.clear();
                    display.updateDisplay(this.store);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid cost:\n" + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            },
            event -> { opDialog.clear(); }
        );
    }

    protected void onInsertComputerClick() {
        Dialog cpDialog = new Dialog(this, "New Computer");
        cpDialog.showComputerDialog(
            event -> { 
                Computer newCP = new Computer(cpDialog.name(), cpDialog.model());
                for (Object op : cpDialog.selectedOps()) {
                    newCP.addOption((Option)op);
                }
                this.store.add(newCP);

                cpDialog.clear();
                display.updateDisplay(this.store);
            },
            event -> { cpDialog.clear(); },
            this.store.options()
        );
    }

    protected void onInsertOrderClick() {
        Object cm = null;
        int cmNum = store.customers().length;
        Dialog orDialog = new Dialog(this, "New Order");
        if (cmNum == 0) {
            onInsertCustomerClick(true);
        }

        if (cmNum == 0) {
            return;
        } else {
            cmNum = store.customers().length;
            if (cmNum == 1) 
                cm = store.customers()[0];
            else if (cmNum > 1) {
                Object[] cms = store.customers();
                JLabel label = new JLabel("Order for which Customer?");
                JComboBox<Object> comboBox = new JComboBox<>(cms);
                Object[] objects = {
                    label,
                    comboBox
                };

                int response = JOptionPane.showConfirmDialog(this, objects, "Select Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.OK_OPTION) {
                    cm = comboBox.getSelectedItem();
                } else {
                    return;
                }
            }
        }

        orDialog.showOrderDialog(
            cm,
            display,
            this.store
        );
    }

    protected void onViewClick(Record record) {
        switch (record) {
            case CUSTOMER -> {display.setView(Record.CUSTOMER);}
            case OPTION -> {display.setView(Record.OPTION);}
            case COMPUTER -> {display.setView(Record.COMPUTER);}
            case ORDER -> {display.setView(Record.ORDER);}
        } 
    }

    protected void onAboutClick() {
        new AboutDialog();
    }
}
