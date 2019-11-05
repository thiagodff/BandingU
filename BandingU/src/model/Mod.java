package model;

public class Mod extends User{

    public Mod(String nome, String password, int ID) {
        super(nome, password, ID);
        rank = 1;
    }

    public boolean banUser(User user) {
        if (user.isValid() && !(user instanceof Admin)) {
            user.setValid(false);
            return true;
        }
        return false;
    }
    
    public Service validate(Submission text, String nome, String desc){
        return new Service(nome, desc, text.subText);
    }
    
}
