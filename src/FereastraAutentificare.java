import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FereastraAutentificare extends JFrame {

    private ManagerAutentificare managerAutentificare;
    private JTextField campNumeUtilizator;
    private JPasswordField campParola;

    public FereastraAutentificare(ManagerAutentificare managerAutentificare) {
        this.managerAutentificare = managerAutentificare;
        setTitle("Autentificare");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        initComponents();
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel etichetaNumeUtilizator = new JLabel("Nume utilizator:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 10, 5, 5);
        add(etichetaNumeUtilizator, gbc);

        campNumeUtilizator = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 5, 5, 10);
        add(campNumeUtilizator, gbc);

        JLabel etichetaParola = new JLabel("Parola:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(5, 10, 10, 5);
        add(etichetaParola, gbc);

        campParola = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 10, 10);
        add(campParola, gbc);

        JButton butonAutentificare = new JButton("Autentificare");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 5, 10, 10);
        add(butonAutentificare, gbc);

        butonAutentificare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeUtilizator = campNumeUtilizator.getText();
                String parola = new String(campParola.getPassword());
                if (managerAutentificare.autentifica(numeUtilizator, parola)) {
                    FereastraAutentificare.this.dispose();
                    List<String> cuvinte = new IncarcatorCuvinte("cuvinte.txt").incarcaCuvinte();
                    FereastraSpanzuratoarea fereastraSpanzuratoarea = new FereastraSpanzuratoarea(cuvinte);
                    fereastraSpanzuratoarea.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(FereastraAutentificare.this, "Nume de utilizator sau parolă incorectă!", "Eroare de autentificare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}