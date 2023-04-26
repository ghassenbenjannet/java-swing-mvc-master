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
}
