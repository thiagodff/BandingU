package model;

public class Admin extends User implements _Admin{

    public Admin(String nome, String password, String nomeCompleto, String email, String telefone, String endereco, boolean provider, int ID) {
        super(nome, password, nomeCompleto, email, telefone, endereco, provider, ID);
        rank = 2;
    }

    @Override
    public boolean banUser(User user) {
        if (user.isValid()) {
            user.setValid(false);
            return true;
        }
        return false;
    }

    @Override
    public User promoteUser(User user) {
        Admin aux = new Admin(user.getNome(), user.getPassword(), user.getNomeCompleto(), user.getEmail(), user.getTelefone(), user.getEndereco(), user.isProvider(), user.getID());
        return aux;
    }

}
