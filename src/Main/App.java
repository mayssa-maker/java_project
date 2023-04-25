import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        // Create a JFrame for the main app window
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create a JPanel and set its layout to GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        // Create a JButton to open the Manage Hotels frame
        JButton manageHotelsButton = new JButton("Manage Hotels");
        manageHotelsButton.addActionListener(e -> {
            // Create a new instance of ManageHotelsFrame and show it
            ManageHotelsFrame manageHotelsFrame = new ManageHotelsFrame();
            manageHotelsFrame.setVisible(true);
        });
        // Create a JButton to open the Manage chambres frame
        JButton manageChambresButton = new JButton("Manage chambres");
        manageChambresButton.addActionListener(e -> {
                 // Create a new instance of ManageChambresFrame and show it
                 ManageChambresFrame manageChambresFrame = new ManageChambresFrame();
                 manageChambresFrame.setVisible(true);
             });
        JButton manageClientsButton = new JButton("Manage clients");
             manageClientsButton.addActionListener(e -> {
                      // Create a new instance of ManageChambresFrame and show it
                      ManageClientsFrame manageClientsFrame = new ManageClientsFrame();
                      manageClientsFrame.setVisible(true);
                  });
        JButton manageReservationsButton = new JButton("Manage clients");
                  manageReservationsButton.addActionListener(e -> {
                           // Create a new instance of ManageChambresFrame and show it
                           ManageReservationsFrame manageReservationsFrame = new ManageReservationsFrame();
                           manageReservationsFrame.setVisible(true);
                       });

        // Add the Manage Hotels button to the panel
        panel.add(manageHotelsButton);
        panel.add(manageChambresButton);
        panel.add(manageClientsButton);
        panel.add(manageReservationsButton);


        // Add the panel to the main frame
        frame.add(panel);

        // Show the main frame
        frame.setVisible(true);
    }

    public void setVisible(boolean b) {
    }
}


