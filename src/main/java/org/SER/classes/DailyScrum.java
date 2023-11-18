package org.SER.classes;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author monil
 */
public class DailyScrum extends javax.swing.JFrame {

    /**
     * Creates new form DailyScrum
     */
    public class TableActionCellRenderDropDown extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, o, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

            PanelActionDropDown action =  new PanelActionDropDown();

            if(isSelected==false && row%2==0){
                action.setBackground(Color.WHITE);
            }else{
                action.setBackground(com.getBackground());
            }
            return action;
        }



    }

    public class TableActionCellEditorDropDown extends DefaultCellEditor{

        public TableActionCellEditorDropDown() {
            super(new JCheckBox());
        }



        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            PanelActionDropDown action = new PanelActionDropDown();
            action.setBackground(table.getSelectionBackground());
            return action;
        }



    }
    public class PanelActionDropDown extends javax.swing.JPanel {

        /**
         * Creates new form PanelAction2
         */
        public PanelActionDropDown() {
            initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jComboBox1 = new javax.swing.JComboBox<>();

            setAlignmentX(0.0F);
            setAlignmentY(0.0F);
            setPreferredSize(new java.awt.Dimension(51, 21));

            jComboBox1.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--UPDATE--", "TODO", "IN_PROGRESS", "DONE", " " }));
            jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBox1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jComboBox1, 0, 76, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
        }// </editor-fold>

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
//            System.out.println(jComboBox1.get);

        }


        // Variables declaration - do not modify
        private javax.swing.JComboBox<String> jComboBox1;
        // End of variables declaration
    }


    public DailyScrum(SprintBacklog sprint) {
        initComponents(sprint);

        TodoTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        TodoTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
        ProgressTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        ProgressTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
        DoneTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        DoneTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(SprintBacklog sprint) {

        jLabel1 = new javax.swing.JLabel();
        ProgressPanel = new javax.swing.JScrollPane();
        ProgressTable = new javax.swing.JTable();
        TodoPanel = new javax.swing.JScrollPane();
        TodoTable = new javax.swing.JTable();
        DonePanel = new javax.swing.JScrollPane();
        DoneTable = new javax.swing.JTable();
        progressLabel = new javax.swing.JLabel();
        todoLabel = new javax.swing.JLabel();
        doneLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daily Scrum");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel1.setText("Daily Scrum");


        List<UserStory> todo= sprint.getUserStoriesbyStatus(Status.TODO);
        List<UserStory> inprogress= sprint.getUserStoriesbyStatus(Status.IN_PROGRESS);
        List<UserStory> done= sprint.getUserStoriesbyStatus(Status.DONE);

        Object[][]  todoRow = new Object[todo.size()][2];
        for (int i = 0; i < todo.size(); i++) {
            todoRow[i][0] = todo.get(i).getTitle();
            todoRow[i][1] = "TODO";

        }
        Object[][]  progressRow = new Object[inprogress.size()][2];
        for (int i = 0; i < inprogress.size(); i++) {
            progressRow[i][0] = inprogress.get(i).getTitle();
            progressRow[i][1] = "IN_PROGRESS";

        }
        Object[][]  doneRow = new Object[done.size()][2];
        for (int i = 0; i < done.size(); i++) {
            doneRow[i][0] = done.get(i).getTitle();
            doneRow[i][1] = "DONE";

        }

        ProgressTable.setModel(new javax.swing.table.DefaultTableModel(
                progressRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProgressTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        ProgressTable.setSelectionForeground(new java.awt.Color(255, 255, 255, 0));
        ProgressTable.setShowHorizontalLines(true);
        ProgressPanel.setViewportView(ProgressTable);
        if (ProgressTable.getColumnModel().getColumnCount() > 0) {
            ProgressTable.getColumnModel().getColumn(1).setMinWidth(100);
            ProgressTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ProgressTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        TodoTable.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TodoTable.setModel(new javax.swing.table.DefaultTableModel(
                todoRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TodoTable.setPreferredSize(new java.awt.Dimension(70, 40));
        TodoTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        TodoTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TodoTable.setShowHorizontalLines(true);
        TodoPanel.setViewportView(TodoTable);
        if (TodoTable.getColumnModel().getColumnCount() > 0) {
            TodoTable.getColumnModel().getColumn(1).setMinWidth(100);
            TodoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            TodoTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        DoneTable.setModel(new javax.swing.table.DefaultTableModel(
                doneRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DoneTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        DoneTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        DoneTable.setShowHorizontalLines(true);
        DonePanel.setViewportView(DoneTable);
        if (DoneTable.getColumnModel().getColumnCount() > 0) {
            DoneTable.getColumnModel().getColumn(1).setMinWidth(100);
            DoneTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DoneTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        progressLabel.setBackground(new java.awt.Color(255, 255, 255));
        progressLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        progressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        progressLabel.setText("IN PROGRESS");

        todoLabel.setBackground(new java.awt.Color(255, 255, 255));
        todoLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        todoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todoLabel.setText("TODO");

        doneLabel.setBackground(new java.awt.Color(255, 255, 255));
        doneLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        doneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doneLabel.setText("DONE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(309, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(todoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                        .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(todoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                        .addComponent(ProgressPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(TodoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyScrum(new SprintBacklog()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane DonePanel;
    private javax.swing.JTable DoneTable;
    private javax.swing.JScrollPane ProgressPanel;
    private javax.swing.JTable ProgressTable;
    private javax.swing.JScrollPane TodoPanel;
    private javax.swing.JTable TodoTable;
    private javax.swing.JLabel doneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JLabel todoLabel;
    // End of variables declaration
}

