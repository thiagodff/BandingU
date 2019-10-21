package model;

import java.util.ArrayList;

public class Users {

    private ArrayList<User> Bank;

    public Users() {
        this.Bank = new ArrayList<>();
    }

    public void insert(User user) {
        Bank.add(user);
    }

    public User[] getArray() {
        return ((User[]) this.Bank.toArray());
    }

    public User getByName(String name) {
        User[] list = new User[1];
        list = this.Bank.toArray(list);
        for (User user : list) {
            if (user.getNome().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
