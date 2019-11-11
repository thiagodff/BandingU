package model;

public class Mod extends User{

    public Mod(String nome, String password, String nomeCompleto, String email, String telefone, String endereco, boolean provider, int ID) {
        super(nome, password, nomeCompleto, email, telefone, endereco, provider, ID);
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
        return new Service(nome, desc, text.subText, text.owner);
    }
    
}
