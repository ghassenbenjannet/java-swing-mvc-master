package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
    }

    // adds user to our collection
    public void addUser(User user) {
        userArrayList.add(user);
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

    // creates a file for the specified user
public void createFileForUser(User user) {
    try {
        File file = new File(user.getEmail() + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    // saves ticket to user's file and data_tickets.txt
    public void saveTicket(Ticket ticket) {
        try {
            // save to user's file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ticket.getCreatedBy().getEmail() + ".txt", true));
            bufferedWriter.write(ticket.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            // save to data_tickets.txt
            bufferedWriter = new BufferedWriter(new FileWriter("data_tickets.txt", true));
            bufferedWriter.write(ticket.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
