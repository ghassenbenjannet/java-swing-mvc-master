package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private final String dataPath = "src/data/";
    private final String ticketExtension = ".txt";

    // Constructeur
public FileManager() {
    // Créer le dossier data s'il n'existe pas
    File dataDirectory = new File(dataPath);
    if (!dataDirectory.exists()) {
        dataDirectory.mkdirs();
    }
}

// Méthode pour enregistrer un ticket dans le fichier approprié
public void saveTicket(Ticket ticket) throws IOException {
    // Récupérer le nom de fichier approprié pour le ticket en fonction du collaborateur
    String filename = dataPath;
    if (ticket.getAssignTo() == null) {
        filename += "data_tickets";
    } else {
        filename += ticket.getAssignTo().getLastname() + "_" + ticket.getAssignTo().getFirstname() + "_Tickets";
    }
    filename += ticketExtension;

    // Créer le fichier s'il n'existe pas
    File ticketFile = new File(filename);
    if (!ticketFile.exists()) {
        ticketFile.createNewFile();
    }

    // Écrire le ticket dans le fichier
    FileWriter writer = new FileWriter(ticketFile, true);
    writer.write(ticket.toString() + "\n");
    writer.close();
}

// Méthode pour récupérer tous les tickets d'un collaborateur
public ArrayList<Ticket> getCollaboratorTickets(Collaborateur collaborateur) throws IOException {
    ArrayList<Ticket> tickets = new ArrayList<>();

    // Récupérer le nom de fichier approprié pour le collaborateur
    String filename = dataPath + collaborateur.getLastname() + "_" + collaborateur.getFirstname() + "_Tickets" + ticketExtension;

    // Lire les tickets du fichier et les ajouter à la liste
    File ticketFile = new File(filename);
    if (ticketFile.exists()) {
        Scanner scanner = new Scanner(ticketFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Ticket ticket = Ticket.fromString(line);
            tickets.add(ticket);
        }
        scanner.close();
    }

    return tickets;
}

// Méthode pour récupérer tous les tickets de l'admin
public ArrayList<Ticket> getAdminTickets() throws IOException {
    ArrayList<Ticket> tickets = new ArrayList<>();

    // Récupérer le nom de fichier approprié pour les tickets de l'admin
    String filename = dataPath + "data_tickets" + ticketExtension;

    // Lire les tickets du fichier et les ajouter à la liste
    File ticketFile = new File(filename);
    if (ticketFile.exists()) {
        Scanner scanner = new Scanner(ticketFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Ticket ticket = Ticket.fromString(line);
            tickets.add(ticket);
        }
        scanner.close();
    }

    return tickets;
}

    
}
