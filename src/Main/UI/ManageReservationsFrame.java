import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class ManageReservationsFrame extends JFrame {

    private JTextField dateDebutField, dateFinField, chambrenumField, clientField, hotelField;

    public ManageReservationsFrame() {
        // set the frame properties
        setTitle("Gestion des réservations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // create the components
        JLabel dateDebutLabel = new JLabel("Date de début:");
        JLabel dateFinLabel = new JLabel("Date de fin:");
        JLabel chambrenumLabel = new JLabel("Numéro de chambre:");
        JLabel clientLabel = new JLabel("Client:");
        JLabel hotelLabel = new JLabel("Hôtel:");

        dateDebutField = new JTextField(10);
        dateFinField = new JTextField(10);
        chambrenumField = new JTextField(10);
        clientField = new JTextField(10);
        hotelField = new JTextField(10);

        JButton saveButton = new JButton("Enregistrer");
        JButton returnButton = new JButton("Retour au menu principal");

        // create the layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(dateDebutLabel, gbc);
        gbc.gridx++;
        panel.add(dateDebutField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(dateFinLabel, gbc);
        gbc.gridx++;
        panel.add(dateFinField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(chambrenumLabel, gbc);
        gbc.gridx++;
        panel.add(chambrenumField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(clientLabel, gbc);
        gbc.gridx++;
        panel.add(clientField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(hotelLabel, gbc);
        gbc.gridx++;
        panel.add(hotelField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(saveButton, gbc);

        gbc.gridx++;
        panel.add(returnButton, gbc);

        add(panel);

        // add action listeners
        saveButton.addActionListener(e -> {
            // get the values from the fields
            LocalDate dateDebut = LocalDate.parse(dateDebutField.getText());
            LocalDate dateFin = LocalDate.parse(dateFinField.getText());
            int chambrenum = Integer.parseInt(chambrenumField.getText());
            String clientName = clientField.getText();
            String hotelName = hotelField.getText();

            // create the reservation object
           // Reservation reservation = new Reservation(new Hotel(hotelName),dateDebut, dateFin, chambrenum,
                    //new Client(clientName));

            // save the reservation to the database or file
            // ...

            // display a message
            JOptionPane.showMessageDialog(null, "La réservation a été enregistrée avec succès.");
        });

        returnButton.addActionListener(e -> {
            // create a new instance of the main frame and make it visible
            App mainFrame = new App();
            mainFrame.setVisible(true);
            // dispose of the current frame
            dispose();
        });
    }
}

