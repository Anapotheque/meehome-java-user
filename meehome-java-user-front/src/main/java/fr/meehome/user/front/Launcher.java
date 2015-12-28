package fr.meehome.user.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

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
                    showAll();break;
                case 2:
                    newUser();break;
                case 3:
                    recherche();break;
                case 4:
                    delete();break;
                case 5:
                    run = false;break;
                default:
                     accueil();break;
            }
        }
        showHeader("Good bye");
    }

    private static int accueil() {
        System.out.println("---------------------------------");
        System.out.println("1 - Liste des users");
        System.out.println("2 - Nouveau user");
        System.out.println("3 - Recherche user par email");
        System.out.println("4 - Suprression user par email");
        System.out.println("5 - Quitter");
        System.out.println("---------------------------------");
        return Integer.parseInt(getString("Choix"));
    }

    private static void showAll() {
        showHeader("Liste des users :");
        List<UserDto> listUserDto = userService.getAll();
        if (listUserDto.isEmpty()) {
            System.out.println("- Aucun user");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getNom() + " - " + userDto.getPrenom() + " - " + userDto.getEmail());
            }
        }
    }

    private static void recherche() {
        showHeader("Recherche users par email :");
        String email = getString("Email");
        List<UserDto> listUserDto = userService.getUserByEmail(email);
        System.out.println("---------------------------------");
        if (listUserDto.isEmpty()) {
            System.out.println("- Aucun user");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getNom() + " - " + userDto.getPrenom() + " - " + userDto.getEmail());
            }
        }
    }

    private static void delete() {
        showHeader("Suppression user par Login");
        String login = getString("Login");

        System.out.println("---------------------------------");
        System.out.print("- Suppression user ");
        if (userService.delete(login)) {
            System.out.println("[OK]");
        } else {
            System.out.println("[ECHEC]");
        }
    }

    private static void newUser() throws NumberFormatException {
        showHeader("Nouveau user");
        String nom = getString("Nom");
        String prenom = getString("Prenom");
        String email = getString("Email");
        String password = getString("Mot de passe");

        UserDto userDto = new UserDto();
        userDto.setNom(nom);
        userDto.setPrenom(prenom);
        userDto.setEmail(email);
        userDto.setPassword(password);

        System.out.println("---------------------------------");
        System.out.print("- Ajout user ");
        if (userService.add(userDto)) {
            System.out.println("[OK]");
        } else {
            System.out.println("[ECHEC]");
        }
    }

    private static void printError(Exception e) {
        showHeader("Erreur de lecture, veuillez reessayer");
        System.out.println(e.getCause());
        e.printStackTrace();
    }

    private static void showHeader(String title){
        System.out.println("---------------------------------");
        System.out.println("- " + title);
        System.out.println("---------------------------------");
    }

    private static String getString(String question){
        try {
            System.out.println("- " + question + ":");
            return bufferedReader.readLine();
        } catch (IOException e) {
            printError(e);
        }
        return null;
    }
}
