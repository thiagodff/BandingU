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
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in = new FileInputStream("data.txt");
        ObjectInputStream readData = new ObjectInputStream(in);

        Users users = (Users) readData.readObject();

        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Deseja mesmo sair?",
                        "Que pena :c", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    try {
                        FileOutputStream out = new FileOutputStream("data.txt");
                        ObjectOutputStream saveData = new ObjectOutputStream(out);
                        saveData.writeObject(users);
                    } catch (IOException e2) {
                        System.err.print("ERROR>" + e2.getMessage());
                    }
                    System.exit(0);
                }
            }
        };

        in.close();

        Login login = new Login(users);
        login.setLocationRelativeTo(null);
        login.addWindowListener(exitListener);
        login.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        login.setVisible(true);

    }

}
