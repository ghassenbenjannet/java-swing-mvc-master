package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;
    private ArrayList<Ticket> ticketsArrayList;
    private final String dataPath = "src/data/";
    private final String ticketExtension = ".txt";
    public Database() {
        userArrayList = new ArrayList<>();
        ticketsArrayList = new ArrayList<>();
    }

    // adds user to our collection
    public void addUser(User user) {
        userArrayList.add(user);
    }

    // adds tickets
    public void addTicket(Ticket t) {
        ticketsArrayList.add(t);
    }

    // saves users to database file
    public void saveUser(File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (User user : userArrayList) {
                String saveData = user.getFirstname() + ", " + user.getLastname() + ", " + user.getEmail() + ", " + user.getPassword() + ", " + user.getRole();
                bufferedWriter.write(saveData);
                bufferedWriter.newLine();
            }
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // saves users to database file
    public void saveTicket(Ticket ticket) throws IOException {
        // Récupérer le nom de fichier approprié pour le ticket en fonction du collaborateur
        String filename = dataPath;
        if (ticket.getAssignTo() == null) {
            filename += "data_tickets";
        } else {
            filename += ticket.getAssignTo().getLastname() + "_" + ticket.getAssignTo().getFirstname() + "_Tickets";
        }
        filename += ticketExtension;
    
        // Créer le fichier DB de tickets du collaborateur s'il n'existe pas
        File ticketFile = new File(filename);
        if (!ticketFile.exists()) {
            ticketFile.createNewFile();
        }
         // Créer le fichier DB de tickets des admins s'il n'existe pas
        File ticketFile_admin = new File(dataPath + "data_tickets" + ticketExtension );
        if (!ticketFile_admin.exists()) {
            ticketFile_admin.createNewFile();
        }
        // Écrire le ticket dans le fichier du collaborateur
        FileWriter writer_collab = new FileWriter(ticketFile, true);
        writer_collab.write(ticket.toString() + "\n");
        writer_collab.close();

        // Écrire le ticket dans le fichier du collaborateur
        FileWriter writer_admin = new FileWriter(ticketFile_admin, true);
        writer_admin.write(ticket.toString() + "\n");
        writer_admin.close();

        // De cette façon, chaque collaborateur aura un fichier de tickets dédié à lui, et les admins auront un seul fichier qui contiendra tout les tickets
    }

    public void UpdateTicketFile(String filePath, String message, String replacement) {
        File file = new File(filePath);
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String currentLine;
    
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.equals(message)) {
                    currentLine = replacement;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (file.delete()) {
            if (!tempFile.renameTo(file)) {
                throw new RuntimeException("Could not rename temp file to replace original file");
            }
        } else {
            throw new RuntimeException("Could not delete original file to replace with new file");
        }
    }
    

    // reads users from database file
    public Object[] loadUsers(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // reads tickets from the specified file and returns a list of tickets
    public ArrayList<Ticket> getTickets(String filename) {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Ticket ticket = Ticket.fromString(line);
                ticketArrayList.add(ticket);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketArrayList;
    }
}
