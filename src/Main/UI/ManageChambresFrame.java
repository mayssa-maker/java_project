import javax.swing.*;
import java.awt.*;

public class ManageChambresFrame extends JFrame{
    public ManageChambresFrame(){
        super("Manage chambre");
        JFrame frame = new JFrame("Chambre Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create a JPanel and set its layout to GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5));

        // Create JLabels and JTextFields for the form
        JLabel idLabel = new JLabel("numero:");
        JTextField idTextField = new JTextField();

        JLabel typeLabel = new JLabel("Type:");
        JTextField typeTextField = new JTextField();

        JLabel priceLabel = new JLabel("tarif:");
        JTextField priceTextField = new JTextField();

        JLabel hotelLabel = new JLabel("Hotel:");
        JTextField hotelTextField = new JTextField();

        //JLabel availableLabel = new JLabel("Available:");
        //JCheckBox availableCheckBox = new JCheckBox();
        // create a button to return to the main frame
        JButton returnButton = new JButton("Return to Main Frame");
        returnButton.addActionListener(e -> {
             // create a new instance of the main frame and make it visible
              App mainFrame = new App();
              mainFrame.setVisible(true);
              // dispose of the current frame
              frame.setVisible(false);
});


        // Add the labels and text fields to the panel
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(typeLabel);
        panel.add(typeTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(hotelLabel);
        panel.add(hotelTextField);
        //panel.add(availableLabel);
        //panel.add(availableCheckBox);

        // Create JButtons to add, edit, and delete chambres
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");


        // Add the buttons to the panel
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        // add the button to the panel
        panel.add(returnButton);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

 

   
}

