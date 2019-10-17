package model;

public class Admin extends User implements _Admin {

    public Admin(String nome, String password, int ID) {
        super(nome, password, ID);
    }

    @Override
    public boolean banUser(User user) {
        if (user.isValid()) {
            user.setValid(false);
            return true;
        }
        return false;
    }

}
