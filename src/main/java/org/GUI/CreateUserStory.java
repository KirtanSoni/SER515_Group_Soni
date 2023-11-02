package org.GUI;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUserStory {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Add User Story");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Add User Story");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField(20);
        
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField(20);
        
        JLabel actorsLabel = new JLabel("Actors involved:");
        JTextField actorsField = new JTextField(20);
        
        JLabel versionLabel = new JLabel("Version:");
        JTextField versionField = new JTextField(20);
        
        JButton addButton = new JButton("Add User Story");
        JButton closeButton = new JButton("Close");

        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Title Label at the Top
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        centerPanel.add(titleLabel, c);

        // Subject
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        centerPanel.add(subjectLabel, c);

        c.gridx = 1;
        centerPanel.add(subjectField, c);

        // Description
        c.gridx = 0;
        c.gridy = 2;
        centerPanel.add(descriptionLabel, c);

        c.gridx = 1;
        centerPanel.add(descriptionField, c);

        // Actors Involved
        c.gridx = 0;
        c.gridy = 3;
        centerPanel.add(actorsLabel, c);

        c.gridx = 1;
        centerPanel.add(actorsField, c);

        // Version
        c.gridx = 0;
        c.gridy = 4;
        centerPanel.add(versionLabel, c);

        c.gridx = 1;
        centerPanel.add(versionField, c);

        // Add Button
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        centerPanel.add(addButton, c);

        // Close Button
        c.gridx = 1;
        centerPanel.add(closeButton, c);

        // Add DocumentFilter to limit input length to 70 characters
        addDocumentFilter(subjectField, 70);
        addDocumentFilter(descriptionField, 70);
        addDocumentFilter(actorsField, 70);
        addDocumentFilter(versionField, 70);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subject = subjectField.getText();
                String description = descriptionField.getText();
                String actors = actorsField.getText();
                String version = versionField.getText();

                if (subject.isEmpty() || description.isEmpty() || actors.isEmpty() || version.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    subjectField.setText("");
                    descriptionField.setText("");
                    actorsField.setText("");
                    versionField.setText("");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close logic");
            }
        });

        panel.add(centerPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void addDocumentFilter(JTextField textField, int maxLength) {
        AbstractDocument document = (AbstractDocument) textField.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String before = currentText.substring(0, offset);
                String after = currentText.substring(offset + length);

                if ((before + text + after).length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                } 
            }
        });
    }
}
