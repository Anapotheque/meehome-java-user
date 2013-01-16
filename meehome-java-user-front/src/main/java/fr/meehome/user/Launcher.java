package fr.meehome.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

public class Launcher {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("fr/meehome/user/services/applicationContext.xml");

    @Autowired
    public IUserService userService;

    public static void main(String[] args) throws IOException {
        boolean run = true;

        System.out.println("---------------------------------");
        System.out.println("- Welcome                       -");
        System.out.println("---------------------------------");

        while (run) {
            switch (showAccueil()) {
                case "1":
                    showListeUser();
                    break;
                case "2":
                    showListeUser();
                    break;
                case "3":
                    showListeUser();
                    break;
                case "4":
                    showListeUser();
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    showAccueil();
                    break;
            }
        }
    }

    private static String showAccueil() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("1 - Liste des utilisateurs");
        System.out.println("2 - Ajouter un utilisateur");
        System.out.println("3 - Modifier un utilisateur");
        System.out.println("4 - Supprimer un utilisateur");
        System.out.println("5 - Quitter");
        System.out.println("---------------------------------");
        return bufferedReader.readLine();
    }

    private static void showListeUser() {
        System.out.println("---------------------------------");
        System.out.println("- Liste des utilisateurs        -");
        System.out.println("---------------------------------");
        IUserService userService = (IUserService ) applicationContext.getBean("IUserService");
        List<UserDto> listUserDto = userService.getAll();
        if (listUserDto.isEmpty()) {
            System.out.println("liste vide...");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getLogin());
            }
        }
    }
}
