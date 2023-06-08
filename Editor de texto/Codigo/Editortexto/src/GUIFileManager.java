import Utilidades.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFileManager {
    private JFrame frame;
    private JTextField fileNameField;
    private JTextArea logArea;
    private FileManager fileManager;

    public GUIFileManager() {
        fileManager = new FileManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("File Manager");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameField = new JTextField(20);
        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameField);

        JButton createButton = new JButton("Create");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton listButton = new JButton("List");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                fileManager.createNewFile(fileName);
                logArea.append("File created: " + fileName + "\n");
                clearFileNameField();
            }
        });
/*
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                String content = JOptionPane.showInputDialog(frame, "Enter the content:", "Edit File", JOptionPane.PLAIN_MESSAGE);
                if (content != null) {
                    fileManager.editFile(fileName, content);
                    logArea.append("File edited: " + fileName + "\n");
                    clearFileNameField();
                }
            }
        });*/


        // Agregar los demás listeners y acciones correspondientes a los botones

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void clearFileNameField() {
        fileNameField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIFileManager();
            }
        });
    }
}
