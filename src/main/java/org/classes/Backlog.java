package src.main.java.org.classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class Backlog extends JFrame {

    private JPanel contentPane;
    private JTable userStoryTable;
    private JScrollPane tableScrollPane;

    public Backlog(Object[][] userStories) {
        setTitle("Product Backlog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblBacklog = new JLabel("Product Backlog");
        lblBacklog.setFont(new Font("Calibri", Font.BOLD, 36));
        titlePanel.add(lblBacklog);

        JButton groomButton = new JButton("Groom");
        groomButton.setFont(new Font("Calibri", Font.BOLD, 24));
        titlePanel.add(Box.createHorizontalGlue()); // Add space to the right
        titlePanel.add(groomButton);

        contentPane.add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"User Story", "Business Value", "Story Points", "Edit", "Delete"};

        TableModel model = new DefaultTableModel(userStories, columnNames) {
            public Class<?> getColumnClass(int column) {
                if (column == 1 || column == 2) {
                    return Integer.class;
                }
                return String.class;
            }

            public boolean isCellEditable(int row, int column) {
                return true; // Make all columns editable
            }
        };

        userStoryTable = new JTable(model) {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 3) {
                    return new ButtonRenderer("Edit");
                } else if (column == 4) {
                    return new ButtonRenderer("Delete");
                }
                return super.getCellRenderer(row, column);
            }

            @Override
            public DefaultCellEditor getCellEditor(int row, int column) {
                if (column == 3) {
                    return new ButtonEditor(new JCheckBox(), "Edit");
                } else if (column == 4) {
                    return new ButtonEditor(new JCheckBox(), "Delete");
                }
                return (DefaultCellEditor) super.getCellEditor(row, column);
            }
        };

        // Set the font for the entire table
        userStoryTable.setFont(new Font("Calibri", Font.PLAIN, 18));

        tableScrollPane = new JScrollPane(userStoryTable);
        contentPane.add(tableScrollPane, BorderLayout.CENTER);
    }

    // Inner class for ButtonRenderer
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String label) {
            setOpaque(true);
            setText(label);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Inner class for ButtonEditor
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            isPushed = false;
            return button.getText();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Backlog backlogFrame = new Backlog(new Object[][]{}); // Initialize with an empty array or provide dynamic data
            backlogFrame.setVisible(true);
        });
    }
}
