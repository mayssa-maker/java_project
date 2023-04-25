import javax.swing.*;
import java.awt.*;

public class ManageClientsFrame extends JFrame {

    public ManageClientsFrame() {
        super("Manage Hotels");
       

      
        JFrame frame = new JFrame("Hotel Management System - Manage Hotels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create a JPanel and set its layout to BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a JPanel for the form fields and set its layout to GridLayout
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        // Create JLabels and JTextFields for the form fields
        JLabel nameLabel = new JLabel("Nom");
        JTextField nameTextField = new JTextField();

        JLabel addressLabel = new JLabel("Email:");
        JTextField addressTextField = new JTextField();
        JLabel telephoneLabel = new JLabel("Telephone:");
        JTextField telephoneTextField = new JTextField();

        //JLabel phoneLabel = new JLabel("Phone:");
        //JTextField phoneTextField = new JTextField();
           // create a button to return to the main frame
        JButton returnButton = new JButton("Return to Main Frame");
        returnButton.addActionListener(e -> {
                // create a new instance of the main frame and make it visible
                 App mainFrame = new App();
                 mainFrame.setVisible(true);
                 // dispose of the current frame
                 frame.setVisible(false);
   });


      

        // Add the labels and text fields to the form panel
        formPanel.add(nameLabel);
        formPanel.add(nameTextField);
        formPanel.add(addressLabel);
        formPanel.add(addressTextField);
        formPanel.add(telephoneLabel);
        formPanel.add(telephoneTextField);
        //formPanel.add(phoneLabel);
        //formPanel.add(phoneTextField);
        

        // Create a JPanel for the buttons and set its layout to FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Create JButtons for the buttons
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // Add the buttons to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        // add the button to the panel
        buttonPanel.add(returnButton);

        // Add the form panel and button panel to the main panel
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame and show the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
