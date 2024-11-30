package btl.weather;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    ObjectInputStream ois;
    Map<String, User> userData = new HashMap<>();
    public UserManager() {
        try {
            File userDataFile = new File("users.dat");
            if (!userDataFile.exists()) {
                userDataFile.createNewFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"));
                oos.writeObject(userData);
                oos.close();
            }
            ois = new ObjectInputStream(new FileInputStream("users.dat"));
            userData = (HashMap<String, User>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateUserByUsername(String username) {
        return userData.containsKey(username);
    }

    public User getUserByUsername(String username) {
        return userData.get(username);
    }

    public void createNewUser(User newUser) {
        userData.put(newUser.getUserId(), newUser);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"));
            oos.writeObject(userData);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
