import java.util.List;

public class Principal {

    public static void main(String[] args) {
        IncarcatorCuvinte incarcatorCuvinte = new IncarcatorCuvinte("cuvinte.txt");
        List<String> cuvinte = incarcatorCuvinte.incarcaCuvinte();
        ManagerAutentificare managerAutentificare = new ManagerAutentificare("utilizatori.txt");

        FereastraAutentificare fereastraAutentificare = new FereastraAutentificare(managerAutentificare);
        fereastraAutentificare.setVisible(true);
    }
}