package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.*;
import view.Login;

public class BandingU {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in;
        FileInputStream servIn;
        ObjectInputStream readData;
        final Users users;

        final ServiceBank serviceBank;

        try {
            in = new FileInputStream("data");
            readData = new ObjectInputStream(in);

            Users aux = (Users) readData.readObject();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de dados corrompido, iniciando um novo...");
            File file = new File("data");
            file.createNewFile();
            Users aux = new Users();
            aux.insert(new Admin("admin", "root", 0));
            FileOutputStream out = new FileOutputStream("data");
            ObjectOutputStream saveData = new ObjectOutputStream(out);
            saveData.writeObject(aux);
            out.close();
        } finally {
            in = new FileInputStream("data");
            readData = new ObjectInputStream(in);
        }

        users = (Users) readData.readObject();

        try {
            in = new FileInputStream("services");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de dados corrompido, iniciando um novo...");
            File file = new File("services");
            file.createNewFile();
            ServiceBank serv = new ServiceBank();
            serv.addService(new Service("exemplo", "esse é um exemplo de pedido de ajuda", "MANO QUERO AJUDA", new Admin("admin", "root", 0)));
            try (FileOutputStream servOut = new FileOutputStream("services")) {
                ObjectOutputStream servOutStr = new ObjectOutputStream(servOut);
                servOutStr.writeObject(serv);
            }
        } finally {
            in = new FileInputStream("services");
            readData = new ObjectInputStream(in);
        }

        serviceBank = (ServiceBank) readData.readObject();

        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Deseja mesmo sair?",
                        "Que pena :c", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    try {
                        FileOutputStream out = new FileOutputStream("data");
                        ObjectOutputStream saveData = new ObjectOutputStream(out);
                        saveData.writeObject(users);

                        out = new FileOutputStream("services");
                        saveData = new ObjectOutputStream(out);
                        saveData.writeObject(serviceBank);

                    } catch (IOException e2) {
                        System.err.print("ERROR>" + e2.getMessage());
                    }
                    System.exit(0);
                }
            }
        };

        in.close();

        Login login = new Login(users, serviceBank);
        login.setLocationRelativeTo(null);
        login.addWindowListener(exitListener);
        login.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        login.setVisible(true);

    }

}
