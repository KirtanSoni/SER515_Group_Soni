package src.main.java.org.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddUserStory extends JFrame {

    private JPanel contentPane;
    private JTextField enterBV;
    private JTextField enterDV;
    private JTextField enterTitle;
    public String tit = new String();
    public String desc = new String();
    public String accept = new String();
    public int bv;
    public int dv;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddUserStory frame = new AddUserStory();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public AddUserStory() {
        setBackground(new Color(192, 192, 192));
        setTitle("Add User Story");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 484);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel panel_1 = new JPanel();

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));

        JPanel panel = new JPanel();

        JLabel title = new JLabel("Title :");
        title.setFont(new Font("Calibri", Font.PLAIN, 16));

        JLabel description = new JLabel("Description :");
        description.setFont(new Font("Calibri", Font.PLAIN, 16));

        JTextArea enterDescription = new JTextArea();
        enterDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                desc = enterDescription.getText();
            }
        });
        enterDescription.setFont(new Font("Calibri", Font.PLAIN, 16));

        JLabel Acceptance = new JLabel("Acceptance Criteria :");
        Acceptance.setFont(new Font("Calibri", Font.PLAIN, 16));

        JTextArea enterAcceptance = new JTextArea();
        enterAcceptance.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                accept = enterAcceptance.getText();
            }
        });
        enterAcceptance.setFont(new Font("Calibri", Font.PLAIN, 16));

        JLabel BV = new JLabel("Business Value :");
        BV.setFont(new Font("Calibri", Font.PLAIN, 16));

        enterBV = new JTextField();
        enterBV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                bv = Integer.parseInt(enterBV.getText());
            }
        });
        enterBV.setFont(new Font("Calibri", Font.PLAIN, 16));
        enterBV.setColumns(10);

        JLabel DV = new JLabel("Developer Value :");
        DV.setFont(new Font("Calibri", Font.PLAIN, 16));

        enterDV = new JTextField();
        enterDV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                dv = Integer.parseInt(enterDV.getText());
            }
        });
        enterDV.setFont(new Font("Calibri", Font.PLAIN, 16));
        enterDV.setColumns(10);

        enterTitle = new JTextField();
        enterTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tit = enterTitle.getText();
            }
        });
        enterTitle.setFont(new Font("Calibri", Font.PLAIN, 16));
        enterTitle.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Add User Story");
        lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 16));
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                                .addGap(492))
                                        .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                                .addGap(21))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(10)
                                .addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addGap(21))
        );
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(20)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(title, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                                                .addGap(24)
                                                                .addComponent(enterTitle, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(description, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                                .addGap(506))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(Acceptance, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(enterAcceptance, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(BV, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                                .addGap(13)
                                                                .addComponent(enterBV, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                                .addGap(55)
                                                                .addComponent(DV, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                                .addGap(10)
                                                                .addComponent(enterDV, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                                .addGap(89))))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(106)
                                                .addComponent(enterDescription, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)))
                                .addGap(6))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(16)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(title, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                                .addGap(1))
                                        .addComponent(enterTitle, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                .addGap(29)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addComponent(description, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                                .addGap(136))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(79)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(Acceptance, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                                        .addComponent(enterAcceptance, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                                .addGap(12))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(enterDescription, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
                                .addGap(13)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(BV, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(2)
                                                .addComponent(enterBV, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                                .addGap(3))
                                        .addComponent(DV, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(2)
                                                .addComponent(enterDV, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                                .addGap(3)))
                                .addGap(24))
        );
        panel.setLayout(gl_panel);
        panel_2.setLayout(gl_panel_2);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserStory us = new UserStory(tit, desc, accept, bv, dv);
                System.out.println(us);
                dispose();
            }
        });
        submit.setForeground(new Color(0, 0, 0));
        submit.setBackground(new Color(255, 255, 255));
        submit.setFont(new Font("Calibri", Font.PLAIN, 16));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                .addGap(6))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                                .addGap(7))
        );
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(568)
                                .addComponent(submit, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addGap(34))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11)
                                .addComponent(submit, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                .addGap(10))
        );
        panel_1.setLayout(gl_panel_1);
        contentPane.setLayout(gl_contentPane);

    }

}
