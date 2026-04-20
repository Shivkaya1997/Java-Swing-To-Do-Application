import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {
    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("Java To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // UI Components
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");

        // Style the list
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Header Panel (Input + Add Button)
        JPanel headerPanel = new JPanel(new BorderLayout(5, 5));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(taskInput, BorderLayout.CENTER);
        headerPanel.add(addButton, BorderLayout.EAST);

        // Footer Panel (Delete Button)
        JPanel footerPanel = new JPanel();
        footerPanel.add(deleteButton);

        // Add Logic for Add Button
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText(""); // Clear input
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task!");
            }
        });

        // Add Logic for Delete Button
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        // Allow pressing "Enter" to add task
        taskInput.addActionListener(e -> addButton.doClick());

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Center and show
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
