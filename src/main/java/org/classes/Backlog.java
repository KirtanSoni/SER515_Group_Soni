package src.main.java.org.classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Backlog extends JFrame {

    private JPanel contentPane;
    private JTable userStoryTable;
    private JScrollPane tableScrollPane;

    public Backlog() {
        setTitle("Product Backlog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Create a panel for the title and "Groom" button
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create a label for the title
        JLabel lblBacklog = new JLabel("Product Backlog");
        lblBacklog.setFont(new Font("Calibri", Font.BOLD, 36));
        titlePanel.add(lblBacklog);

        // Create a button for "Groom"
        JButton groomButton = new JButton("Groom");
        groomButton.setFont(new Font("Calibri", Font.BOLD, 24));
        titlePanel.add(Box.createHorizontalGlue()); // Add space to the right
        titlePanel.add(groomButton);

        contentPane.add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"User Story", "Business Value", "Story Points", "Edit", "Delete"};
        Object[][] userStories = {
                {"User Story 1: As a user, I want...", 5, 5, "Edit", "Delete"},
                {"User Story 2: As a user, I want...", 3, 3, "Edit", "Delete"},
                {"User Story 3: As a user, I want...", 2, 2, "Edit", "Delete"},
                // Add more user stories here
        };

        TableModel model = new DefaultTableModel(userStories, columnNames) {
            public Class<?> getColumnClass(int column) {
                if (column == 1 || column == 2) {
                    return Integer.class; // Make Business Value and Story Points columns display numbers
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
                    return new ButtonEditor(new JCheckBox(), "Edit", this);
                } else if (column == 4) {
                    return new ButtonEditor(new JCheckBox(), "Delete", this);
                }
                return (DefaultCellEditor) super.getCellEditor(row, column);
            }
        };

        // Set the font for the entire table
        userStoryTable.setFont(new Font("Calibri", Font.PLAIN, 18));

        tableScrollPane = new JScrollPane(userStoryTable);
        contentPane.add(tableScrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Backlog backlogFrame = new Backlog();
                backlogFrame.setVisible(true);
            }
        });
    }
}

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

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private boolean isPushed;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, String label, JTable table) {
        super(checkBox);
        this.table = table;
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
        if (isPushed && "Delete".equals(button.getText())) {
            JOptionPane.showMessageDialog(null, "Delete clicked for row " + table.getSelectedRow());
        }
        isPushed = false;
        return button.getText();
    }
}
