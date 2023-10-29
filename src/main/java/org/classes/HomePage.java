package org.classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Dimension;

public class HomePage extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage frame = new HomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
//	public static void HP() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage frame = new HomePage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
    /**
     * Create the frame.
     */
    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 484);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("SprintMeta");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        lblNewLabel.setBounds(269, 122, 186, 47);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Product Backlog");
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
        btnNewButton.setBounds(71, 236, 171, 47);
        contentPane.add(btnNewButton);

        JButton btnDailyScrum = new JButton("Daily Scrum");
        btnDailyScrum.setFont(new Font("Calibri", Font.BOLD, 18));
        btnDailyScrum.setBounds(273, 236, 171, 47);
        contentPane.add(btnDailyScrum);

        JButton btnSprintBacklog = new JButton("Sprint Backlog");
        btnSprintBacklog.setFont(new Font("Calibri", Font.BOLD, 18));
        btnSprintBacklog.setBounds(468, 236, 171, 47);
        contentPane.add(btnSprintBacklog);

    }

}