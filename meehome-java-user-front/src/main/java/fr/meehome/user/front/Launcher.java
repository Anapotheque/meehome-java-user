package fr.meehome.user.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import fr.meehome.user.services.dto.UserDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.meehome.user.services.IUserService;

public class Launcher {

    public static BufferedReader bufferedReader;

    public static ApplicationContext applicationContext;

    public static IUserService userService;

    public static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        applicationContext = new ClassPathXmlApplicationContext("fr/meehome/user/services/applicationContext.xml");
        userService = (IUserService ) applicationContext.getBean("userServiceImpl");
        showHeader("Welcome");
    }

    public static void main(String[] args) {
        init();
        boolean run = true;
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
            printSeparator();
            print("1 - Nouvel utilisateur");
            print("2 - Liste des utilisateurs");
            print("3 - Recherche utilisateur par email");
            print("4 - Suprression utilisateur par identifiant");
            print("5 - Quitter");
            printSeparator();
            return Integer.parseInt(getString("Choix"));
        } catch (Exception e){
            printError(e);
            accueil();
        }
        return 0;
    }

    /**
     *
     */
    private static void show() {
        showHeader("Liste des utilisateurs :");
        show(userService.getAll());
    }

    /**
     *
     */
    private static void search() {
        showHeader("Recherche utilisateur par email :");
        show(userService.getUserByEmail(getString("Email")));
    }

    /**
     *
     * @param listUserDto
     */
    private static void show(List<UserDto> listUserDto) {
        if (listUserDto.isEmpty()) {
            print("- Liste utilisateur vide");
        } else {
            listUserDto.stream().forEach(u -> print(u.toString()));
        }
    }

    /**
     *
     */
    private static void delete() {
        showHeader("Supression utilisateur par identifiant");
        print(userService.deleteById(getString("identifiant")) ? "[OK]" : "[ECHEC]");
    }

    /**
     *
     * @throws NumberFormatException
     */
    private static void addUser() throws NumberFormatException {
        showHeader("Nouvel utilisateur");
        UserDto userDto = new UserDto();
        userDto.setNom(getString("Nom"));
        userDto.setPrenom(getString("Prenom"));
        userDto.setEmail(getString("Email"));
        userDto.setPassword(getString("Mot de passe"));
        printSeparator();
        print(userService.add(userDto) ? "[OK]" : "[ECHEC]");
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
        printSeparator();
        print("- " + title);
        printSeparator();
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

    /**
     *
     * @param msg
     */
    private static void print(String msg) {
        System.out.println(msg);
    }

    /**
     *
     */
    private static void printSeparator() {
        print("---------------------------------");
    }

}
