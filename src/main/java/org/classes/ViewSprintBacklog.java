package src.main.java.org.classes;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;


import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewSprintBacklog extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField date1;
    private JTextField date2;
    private JTable logsTable;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewSprintBacklog frame = new ViewSprintBacklog();
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
    public ViewSprintBacklog() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(110, 110, 806, 532);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel MainPanel = new JPanel();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 781, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JLabel sprintBacklog = new JLabel("Sprint Backlog");
        sprintBacklog.setBounds(21, 15, 112, 21);
        sprintBacklog.setFont(new Font("Calibri", Font.PLAIN, 18));
        sprintBacklog.setBackground(new Color(255, 255, 255));
        MainPanel.setLayout(null);
        MainPanel.add(sprintBacklog);

        JButton Result = new JButton("Result");
        Result.setFont(new Font("Calibri", Font.PLAIN, 14));
        Result.setBounds(308, 15, 85, 21);
        MainPanel.add(Result);

        JButton Report = new JButton("Report");
        Report.setFont(new Font("Calibri", Font.PLAIN, 14));
        Report.setBounds(403, 15, 85, 21);
        MainPanel.add(Report);

        JPanel RightPanel = new JPanel();
        RightPanel.setBackground(new Color(255, 255, 255));
        RightPanel.setBounds(508, 10, 263, 467);
        MainPanel.add(RightPanel);

        JLabel start = new JLabel("Scheduled to Start :");
        start.setFont(new Font("Calibri", Font.PLAIN, 14));

        date1 = new JTextField();
        date1.setFont(new Font("Calibri", Font.PLAIN, 12));
        date1.setColumns(10);

        JLabel end = new JLabel("Scheduled to End :");
        end.setFont(new Font("Calibri", Font.PLAIN, 14));

        date2 = new JTextField();
        date2.setFont(new Font("Calibri", Font.PLAIN, 12));
        date2.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_RightPanel = new GroupLayout(RightPanel);
        gl_RightPanel.setHorizontalGroup(
                gl_RightPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_RightPanel.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_RightPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(start, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(end, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addGap(130))
                        .addGroup(Alignment.TRAILING, gl_RightPanel.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        gl_RightPanel.setVerticalGroup(
                gl_RightPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_RightPanel.createSequentialGroup()
                                .addGap(36)
                                .addComponent(start)
                                .addGap(6)
                                .addComponent(date1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(end)
                                .addGap(6)
                                .addComponent(date2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                .addGap(160))
        );

        logsTable = new JTable();
        logsTable.setFont(new Font("Calibri", Font.PLAIN, 12));
        logsTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                },
                new String[] {
                        "Logs :"
                }
        ));
        scrollPane.setViewportView(logsTable);
        RightPanel.setLayout(gl_RightPanel);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(70);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(30, 162, 225));
        progressBar.setBounds(143, 14, 146, 21);
        MainPanel.add(progressBar);

        JSeparator separator = new JSeparator();
        separator.setBounds(498, 0, 0, 487);
        MainPanel.add(separator);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(21, 46, 465, 417);
        MainPanel.add(scrollPane_1);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        scrollPane_1.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "User Story", "Business Value", "Story Points", "Edit", "Delete"
                }
        ));



        table.getColumnModel().getColumn(0).setPreferredWidth(195);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(31);
        table.getColumnModel().getColumn(4).setPreferredWidth(42);
        contentPane.setLayout(gl_contentPane);

    }
}
