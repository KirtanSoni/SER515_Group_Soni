package src.main.java.org.classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class Backlog extends JFrame {

    private final ProductBacklog productbacklog;

    public Backlog(ProductBacklog productbacklog) {
        this.productbacklog = productbacklog;

        List<UserStory> userStories = productbacklog.getUserStories();
        Object[][] concatedStories = new Object[userStories.size()][5];

        for (int i = 0; i < userStories.size(); i++) {
            UserStory userStory = userStories.get(i);
            concatedStories[i][0] = userStory.getTitle() + ":" + userStory.getId();
            concatedStories[i][1] = userStory.getBusinessValue();
            concatedStories[i][2] = userStory.getDeveloperValue();
            concatedStories[i][3] = "Edit";
            concatedStories[i][4] = "Delete";
        }

        setTitle("Product Backlog");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblBacklog = new JLabel("Product Backlog");
        lblBacklog.setFont(new Font("Calibri", Font.BOLD, 36));
        titlePanel.add(lblBacklog);

        JButton addUserStoryButton = new JButton("Add User Story");
        addUserStoryButton.setFont(new Font("Calibri", Font.BOLD, 24));
        addUserStoryButton.addActionListener(e -> {
            AddUserStory aus = new AddUserStory(productbacklog);
            aus.setVisible(true);
        });
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(addUserStoryButton);

        contentPane.add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"User Story", "Business Value", "Story Points", "Edit", "Delete"};
        TableModel model = new DefaultTableModel(concatedStories, columnNames) {
            public Class<?> getColumnClass(int column) {
                if (column == 1 || column == 2) {
                    return Integer.class;
                }
                return String.class;
            }

        };

        JTable userStoryTable = new JTable(model) {
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
                    return new ButtonEditor(new JCheckBox(), "Edit", row) {
                    };
                } else if (column == 4) {
                    return new ButtonEditor(new JCheckBox(), "Delete", row);
                }
                return (DefaultCellEditor) super.getCellEditor(row, column);
            }
        };

        userStoryTable.setFont(new Font("Calibri", Font.PLAIN, 18));

        JScrollPane tableScrollPane = new JScrollPane(userStoryTable);
        contentPane.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void editUserStory(int row) {
        UserStory selectedUserStory = getUserStoryFromRow(row);
        EditUserStoryModal editModal = new EditUserStoryModal(selectedUserStory);
        editModal.setVisible(true);
    }

    private UserStory getUserStoryFromRow(int row) {
        List<UserStory> userStories = productbacklog.getUserStories();
        return userStories.get(row);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
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
        private final int row;

        public ButtonEditor(JCheckBox checkBox, String label, int row) {
            super(checkBox);
            this.row = row;
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }

        @Override
        public void fireEditingStopped() {
            super.fireEditingStopped();
            editUserStory(row);
        }
    }
}

class EditUserStoryModal extends JDialog {
    private final JTextField titleField;
    private final JTextField businessValueField;
    private final JTextField developerValueField;

    // Store the original values
    private final String oldTitle;
    private final int oldBusinessValue;
    private final int oldDeveloperValue;

    public EditUserStoryModal(UserStory userStory) {
        // Capture the original values
        this.oldTitle = userStory.getTitle();
        this.oldBusinessValue = userStory.getBusinessValue();
        this.oldDeveloperValue = userStory.getDeveloperValue();

        setTitle("Edit User Story");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(userStory.getTitle());
        JLabel businessValueLabel = new JLabel("Business Value:");
        businessValueField = new JTextField(String.valueOf(userStory.getBusinessValue()));
        JLabel developerValueLabel = new JLabel("Developer Value:");
        developerValueField = new JTextField(String.valueOf(userStory.getDeveloperValue()));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            // Update the UserStory object with edited values
            userStory.setTitle(titleField.getText());
            userStory.setBusinessValue(Integer.parseInt(businessValueField.getText()));
            userStory.setDeveloperValue(Integer.parseInt(developerValueField.getText()));
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Calculate the center position
            int x = (screenSize.width - getWidth()) / 2;
            int y = (screenSize.height - getHeight()) / 2;

            // Set the location
            // Print both old and new values
            System.out.println("Old Values: Title = " + oldTitle + ", Business Value = " + oldBusinessValue + ", Developer Value = " + oldDeveloperValue);
            System.out.println("New Values: Title = " + userStory.getTitle() + ", Business Value = " + userStory.getBusinessValue() + ", Developer Value = " + userStory.getDeveloperValue());

            // Close the modal
            setLocation(x, y);

            dispose();
        });

        add(titleLabel);
        add(titleField);
        add(businessValueLabel);
        add(businessValueField);
        add(developerValueLabel);
        add(developerValueField);
        add(new JLabel()); // Empty space
        add(saveButton);
    }
}
