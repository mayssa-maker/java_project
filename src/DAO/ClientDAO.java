package DAO;
import java.util.ArrayList;
import java.util.List;

import Main.Models.Client;

public class ClientDAO {
    private static List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void updateClient(Client client) {
        int index = clients.indexOf(client);
        if (index >= 0) {
            clients.set(index, client);
        }
    }

    public static void deleteClient(Client client) {
        clients.remove(client);
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public Client getClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
}

