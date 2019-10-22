package control;

import model.*;
import view.Login;

public class BandingU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Users users = new Users();
        Admin root = new Admin("root", "adminMaxSecurity", 0);
        users.insert(root);
        
        Login login = new Login(users);
        login.setLocationRelativeTo(null);
        
        login.setVisible(true);
        
        
    }
    
}
