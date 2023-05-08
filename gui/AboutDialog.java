package gui;

import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Component;
import java.awt.Font;

/** Custom class that displays the about dialog
 */
public class AboutDialog extends JDialog {
    private final String appName = "ELSA Store management engine";
    private final String teamName = "Intelligent-Ish Software Designs Inc.";
    private final String license = "GNU General Public License v3.0";
    private final String imgLicense = "Images are original and were not used from outside sources";
    private final double versionNum = 1.4;
    
    public AboutDialog() {
        setTitle("About");
        setSize(400, 450);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);

        //Drawing at the top
        JPanel drawPnl = new JPanel();
        drawPnl.setLayout(new BoxLayout(drawPnl, BoxLayout.LINE_AXIS));
        drawPnl.add(Box.createHorizontalGlue());
        drawPnl.add(new Canvas());
        drawPnl.setAlignmentX(Component.CENTER_ALIGNMENT);
        drawPnl.add(Box.createHorizontalGlue());
        add(drawPnl);
        
        //Body with Text
        JPanel bodyPnl = new JPanel();
        bodyPnl.setLayout(new BoxLayout(bodyPnl, BoxLayout.Y_AXIS));
        bodyPnl.setSize(400, 200);

        // JPanel txtPnl = new JPanel();
        // txtPnl.setLayout(new BoxLayout(txtPnl, BoxLayout.Y_AXIS));
       
        //App Name text
        JTextPane lbl1 = new JTextPane();
        StyledDocument paneStyle1 = lbl1.getStyledDocument();
        //Used to center text in JTextPane
        SimpleAttributeSet centerAttr = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAttr, StyleConstants.ALIGN_CENTER);
        paneStyle1.setParagraphAttributes(0, paneStyle1.getLength(), centerAttr, false);
        
        lbl1.setText(appName);
        lbl1.setEditable(false);
        lbl1.setBackground(UIManager.getColor("Label.background"));
        lbl1.setBorder(UIManager.getBorder("Label.border"));
        lbl1.setOpaque(false);
        lbl1.setFont(new Font("Monospace", Font.BOLD, 20));
        lbl1.setAlignmentX(CENTER_ALIGNMENT);
        lbl1.setSize(400, 50);
        
        //App version number
        JTextPane versionLbl = new JTextPane();
        StyledDocument versionLblStyle = versionLbl.getStyledDocument();
        versionLblStyle.setParagraphAttributes(0, versionLblStyle.getLength(), centerAttr, false);

        versionLbl.setText("Version " + versionNum);
        versionLbl.setEditable(false);
        versionLbl.setBackground(UIManager.getColor("Label.background"));
        versionLbl.setBorder(UIManager.getBorder("Label.border"));
        versionLbl.setOpaque(false);
        versionLbl.setFont(new Font("Monospace", Font.BOLD, 14));
        versionLbl.setAlignmentX(CENTER_ALIGNMENT);
        versionLbl.setSize(400, 50);
        
        //Team Name text
        JTextPane lbl2 = new JTextPane();
        StyledDocument paneStyle2 = lbl2.getStyledDocument();
        paneStyle2.setParagraphAttributes(0, paneStyle2.getLength(), centerAttr, false);

        lbl2.setText(teamName);
        lbl2.setEditable(false);
        lbl2.setBackground(UIManager.getColor("Label.background"));
        lbl2.setBorder(UIManager.getBorder("Label.border"));
        lbl2.setOpaque(false);
        lbl2.setFont(new Font("Monospace", Font.ITALIC, 18));
        lbl2.setAlignmentX(CENTER_ALIGNMENT);
        lbl2.setSize(400, 50);
        
        //License text
        JTextPane lbl3 = new JTextPane();
        StyledDocument paneStyle3 = lbl3.getStyledDocument();
        paneStyle3.setParagraphAttributes(0, paneStyle3.getLength(), centerAttr, false);

        lbl3.setText(license);
        lbl3.setEditable(false);
        lbl3.setBackground(UIManager.getColor("Label.background"));
        lbl3.setBorder(UIManager.getBorder("Label.border"));
        lbl3.setOpaque(false);
        lbl3.setFont(new Font("Monospace", Font.ITALIC, 16));
        lbl3.setAlignmentX(CENTER_ALIGNMENT);
        lbl3.setSize(400, 50);

        //Image License text
        JTextPane lbl4 = new JTextPane();
        StyledDocument paneStyle4 = lbl4.getStyledDocument();
        paneStyle4.setParagraphAttributes(0, paneStyle4.getLength(), centerAttr, false);

        lbl4.setText(imgLicense);
        lbl4.setEditable(false);
        lbl4.setBackground(UIManager.getColor("Label.background"));
        lbl4.setBorder(UIManager.getBorder("Label.border"));
        lbl4.setOpaque(false);
        lbl4.setFont(new Font("Monospace", Font.PLAIN, 14));
        lbl4.setAlignmentX(CENTER_ALIGNMENT);
        lbl4.setSize(400, 50);

        bodyPnl.add(lbl1);
        bodyPnl.add(versionLbl);
        bodyPnl.add(lbl2);
        bodyPnl.add(lbl3);
        bodyPnl.add(lbl4);
        
        // txtPnl.setAlignmentX(CENTER_ALIGNMENT);
        // bodyPnl.add(txtPnl);
        
        add(bodyPnl);

        // add(Box.createRigidArea(new Dimension(0, 10)));

        //Link to docs: https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html

        //Button at the bottom
        JPanel btnPnl = new JPanel(); 
        btnPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(event -> dispose());
        okBtn.setAlignmentX(CENTER_ALIGNMENT);
        btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.LINE_AXIS));
        btnPnl.add(Box.createHorizontalGlue());
        btnPnl.add(okBtn);
        btnPnl.add(Box.createHorizontalGlue());

        add(btnPnl);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
