package org.classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
//      setExtendedState(JFrame.MAXIMIZED_BOTH);              // Full-screen
// 		setBounds(100, 100, 733, 484);				         // default size
        setBounds(110, 110, 806, 532);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("SprintMeta");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 36));

        JButton btnProductBacklogButton = new JButton("Product Backlog");
        btnProductBacklogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnProductBacklogButton, "Under Development");
            }
        });
        btnProductBacklogButton.setFont(new Font("Calibri", Font.BOLD, 18));

        JButton btnDailyScrum = new JButton("Daily Scrum");
        btnDailyScrum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnDailyScrum, "Under Development");
            }
        });
        btnDailyScrum.setFont(new Font("Calibri", Font.BOLD, 18));

        JButton btnSprintBacklog = new JButton("Sprint Backlog");
        btnSprintBacklog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnSprintBacklog, "Under Development");
            }
        });
        btnSprintBacklog.setFont(new Font("Calibri", Font.BOLD, 18));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(264)
                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addGap(259))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(66)
                                .addComponent(btnProductBacklogButton, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addGap(31)
                                .addComponent(btnDailyScrum, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addGap(24)
                                .addComponent(btnSprintBacklog, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addGap(75))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(117)
                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addGap(67)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnProductBacklogButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(btnDailyScrum, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(btnSprintBacklog, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                .addGap(159))
        );
        contentPane.setLayout(gl_contentPane);

    }

}

