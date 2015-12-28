package fr.meehome.user.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.User;

public class Launcher {

    public static BufferedReader bufferedReader;

    public static ApplicationContext applicationContext;

    public static IUserService userService;

    public static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        applicationContext = new ClassPathXmlApplicationContext("fr/meehome/user/services/applicationContext.xml");
        userService = (IUserService ) applicationContext.getBean("userServiceImpl");
    }

    public static void main(String[] args) {
        init();
        boolean run = true;
        showHeader("Welcome");
        while (run) {
            switch (accueil()) {
                case 1:
                    addUser();break;
                case 2:
                    show();break;
                case 3:
                    search();break;
                case 4:
                    delete();break;
                case 5:
                    run = false;break;
                default:
                     accueil();break;
            }
        }
    }

    /**
     *
     * @return
     */
    private static int accueil() {
        try {
            print("---------------------------------");
            print("1 - Nouveau user");
            print("2 - Liste des users");
            print("3 - Recherche user par email");
            print("4 - Suprression user par identifiant");
            print("5 - Quitter");
            print("---------------------------------");
            return Integer.parseInt(getString("Choix"));
        } catch (Exception e){
            print("Le format n'est pas bon, veuillez taper un chiffre.");
            accueil();
        }
        return 0;
    }

    /**
     *
     */
    private static void show() {
        showHeader("Liste des users :");
        List<User> listUser = userService.getAll();
        if (listUser.isEmpty()) {
            print("- Aucun user");
        } else {
            for (User user : listUser) {
                print(user.getId() + " - " + user.getNom() + " - " + user.getPrenom() + " - " + user.getEmail());
            }
        }
    }

    /**
     *
     */
    private static void search() {
        showHeader("Recherche users par email :");
        String email = getString("Email");
        List<User> listUser = userService.getUserByEmail(email);
        print("---------------------------------");
        if (listUser.isEmpty()) {
            print("- Aucun user");
        } else {
            for (User user : listUser) {
                print(user.getNom() + " - " + user.getPrenom() + " - " + user.getEmail());
            }
        }
    }

    /**
     *
     */
    private static void delete() {
        showHeader("Supression user par identifiant");
        String id = getString("identifiant");
        print("---------------------------------");
        System.out.print("- Suppression user ");
        if (userService.deleteById(id)) {
            print("[OK]");
        } else {
            print("[ECHEC]");
        }
    }

    /**
     *
     * @throws NumberFormatException
     */
    private static void addUser() throws NumberFormatException {
        showHeader("Nouveau user");
        User user = new User();
        user.setNom(getString("Nom"));
        user.setPrenom(getString("Prenom"));
        user.setEmail(getString("Email"));
        user.setPassword(getString("Mot de passe"));
        print("---------------------------------");
        System.out.print("- Ajout user ");
        if (userService.add(user)) {
            print("[OK]");
        } else {
            print("[ECHEC]");
        }
    }

    /**
     *
     * @param msg
     */
    private static void print(String msg) {
        System.out.println(msg);
    }

    /**
     *
     * @param e
     */
    private static void printError(Exception e) {
        showHeader("Erreur de lecture, veuillez reessayer");
        print(e.getMessage());
        e.printStackTrace();
    }

    /**
     *
     * @param title
     */
    private static void showHeader(String title){
        print("---------------------------------");
        print("- " + title);
        print("---------------------------------");
        print("");
    }

    /**
     *
     * @param question
     * @return
     */
    private static String getString(String question){
        try {
            print("- " + question + ":");
            return bufferedReader.readLine();
        } catch (IOException e) {
            printError(e);
        }
        return null;
    }
}
