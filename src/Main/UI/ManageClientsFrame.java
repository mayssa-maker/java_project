package Main.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.App;
import Main.Models.Client;
import DAO.*;

public class ManageClientsFrame extends JFrame {
    private ClientDAO clientDAO = new ClientDAO();

    private JTextField txtName = new JTextField(10);
    private JTextField txtEmail = new JTextField(10);
    private JTextField txtTelephone = new JTextField(10);
    private JButton btnSave = new JButton("Save");
    private JButton btnAdd = new JButton("Add");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnLoad = new JButton("Load");
    private JButton returnButton = new JButton("Return to Main Frame");


    // Create a new JTable with column names and zero rows
    String[] columnNames = {"Name", "Email", "Telephone"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    JTable tblClients = new JTable(model);

    public ManageClientsFrame() {
        JFrame frame = new JFrame("Hotel Management System - Manage Clients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(txtEmail);
        inputPanel.add(new JLabel("Telephone:"));
        inputPanel.add(txtTelephone);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnLoad);
        buttonPanel.add(returnButton);

        formPanel.add(inputPanel, BorderLayout.NORTH);
        formPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(formPanel, BorderLayout.NORTH);

        // Clients table
        JScrollPane scrollPane = new JScrollPane(tblClients);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Load all clients on startup
        loadClients();

        // Add event listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadClients();
            }
        });
        returnButton.addActionListener(e -> {
            // create a new instance of the main frame and make it visible
             App mainFrame = new App();
             mainFrame.setVisible(true);
             // dispose of the current frame
             frame.setVisible(false);
});
    frame.setVisible(true);

    }

    private void loadClients() {
        // Clear the table before loading new data
        model.setRowCount(0);

        // Get all clients from the DAO
        List<Client> clients = clientDAO.getAllClients();

        // Add each client to the table
        for (Client client : clients) {
            Object[] rowData = {client.getName(), client.getEmail(), client.getTelephone()};
            model.addRow(rowData);
        }
    }

    private void addClient() {
        // Create a new client from the input fields
        String name = txtName.getText();
        String email = txtEmail.getText();
        String telephone = txtTelephone.getText();

        Client client = new Client(name, email, telephone);

        // Add the client to the DAO
        clientDAO.addClient(client);
           
   

    // Add the client to the table
    Object[] rowData = {client.getName(), client.getEmail(), client.getTelephone()};
    model.addRow(rowData);

    // Clear the input fields
    txtName.setText("");
    txtEmail.setText("");
    txtTelephone.setText("");
}

private void deleteClient() {
    // Get the selected row index
    int rowIndex = tblClients.getSelectedRow();

    // Check if a row is selected
    if (rowIndex < 0) {
        return;
    }

    // Get the client from the selected row
    String name = (String) model.getValueAt(rowIndex, 0);
    String email = (String) model.getValueAt(rowIndex, 1);
    String telephone = (String) model.getValueAt(rowIndex, 2);
    Client client = new Client(name, email, telephone);

    // Remove the client from the DAO
    ClientDAO.deleteClient(client);

    // Remove the client from the table
    model.removeRow(rowIndex);
}

public static void main(String[] args) {
    ManageClientsFrame frame = new ManageClientsFrame();
    frame.setVisible(true);
}
}


