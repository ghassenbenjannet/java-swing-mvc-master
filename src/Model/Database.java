package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;
    private ArrayList<Ticket> ticketsArrayList;

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
    public void saveTicket(File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Ticket ticket : ticketsArrayList) {
                String saveData = ticket.getTitle() + "/ " + ticket.getDescreption() + "/ " + ticket.getCreatedBy() + "/ " + ticket.getAssignTo() + "/ " + ticket.getStatus();
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
