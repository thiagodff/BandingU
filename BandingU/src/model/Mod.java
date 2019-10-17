package model;

public class Mod extends User implements _Admin{

    public Mod(String nome, String password, int ID) {
        super(nome, password, ID);
    }

    @Override
    public boolean banUser(User user) {
        if (user.isValid() && !(user instanceof Admin)) {
            user.setValid(false);
            return true;
        }
        return false;
    }
    
}
