package org.SER.classes;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backlog extends JFrame {

    private JPanel contentPane;
    private JTable userStoryTable;
    private JScrollPane tableScrollPane;
    private SprintBacklog sp;

    public Backlog(ProductBacklog productbacklog, SprintBacklog sp) {
        this.sp = sp;
        List<UserStory> Userstories = productbacklog.getUserStories();
        Object[][] concatedStories = new Object[Userstories.size()][5];

        for (int i = 0; i < Userstories.size(); i++) {
            UserStory userStory = Userstories.get(i);
            concatedStories[i][0] = userStory.getTitle() +":"+ userStory.getId();
            concatedStories[i][1] = userStory.getBusinessValue();
            concatedStories[i][2] = userStory.getDeveloperValue();
            concatedStories[i][3] = userStory.getId();
            concatedStories[i][4] = "Delete";
        }

        System.out.print(Arrays.deepToString(concatedStories));

// Store the concatenated user stories in a new variable.
        setTitle("Product Backlog");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        JButton addUserStoryButton = new JButton("Add User Story");
        addUserStoryButton.setFont(new Font("Calibri", Font.BOLD, 24));
        addUserStoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddUserStory aus = new AddUserStory(productbacklog);
                aus.setVisible(true);
                contentPane.setVisible(false);
                contentPane.setVisible(true);
            }
        });
        titlePanel.add(Box.createHorizontalGlue()); // Add space to the right
        titlePanel.add(addUserStoryButton);

        contentPane.add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"User Story", "Business Value", "Story Points", "Move", "Delete"};
        TableModel model = new DefaultTableModel(concatedStories, columnNames) {
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
                    return new ButtonRenderer("Move");
                } else if (column == 4) {
                    return new ButtonRenderer("Delete");
                }
                return super.getCellRenderer(row, column);
            }

            @Override
            public DefaultCellEditor getCellEditor(int row, int column) {
                if (column == 3) {
                    System.out.println(productbacklog.getUserStories().get(row));
                    Helpers.Move(productbacklog.getUserStories().get(row),productbacklog,sp);
                    return new ButtonEditor(new JCheckBox(), "Move");
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
        @Override
        public void fireEditingStopped() {
            super.fireEditingStopped();
            Helpers helpers = new Helpers();
            System.out.println(this.getCellEditorValue().toString());
        }
    }

    public static List<UserStory> getUserStoriesFromMongoDB() {
        List<UserStory> userStories = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/")) {
            MongoDatabase database = mongoClient.getDatabase("ScrumSimulator");
            MongoCollection<Document> userStoryCollection = database.getCollection("ProductBacklog");

            for (Document document : userStoryCollection.find()) {
                UserStory userStory = new UserStory(
//                        document.getInteger("id"),
                        document.getString("title"),
                        document.getString("description"),
                        document.getString("acceptanceCriteria"),
                        document.getInteger("businessValue"),
                        document.getInteger("developerValue")
                );
                userStories.add(userStory);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., log it or show an error message)
        }

        return userStories;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            Backlog backlogFrame = new Backlog(new Object[][]{}); // Initialize with an empty array or provide dynamic data
//            backlogFrame.setVisible(true);

        });
    }
}
