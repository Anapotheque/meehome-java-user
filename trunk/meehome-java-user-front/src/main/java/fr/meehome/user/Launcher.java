package fr.meehome.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        userService = (IUserService ) applicationContext.getBean("IUserService");
    }

    public static void main(String[] args) {

        init();

        boolean run = true;

        System.out.println("---------------------------------");
        System.out.println("- Welcome                       -");
        System.out.println("---------------------------------");

        while (run) {
            try {
                switch (showAccueil()) {
                    case 1:
                        showListeUser();
                        break;
                    case 2:
                        try {
                            addUser();
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("---------------------------------");
                            System.out.println("Erreur de lecture, veuillez reessayer");
                            System.out.println("---------------------------------");
                        }
                        break;
                    case 3:
                        try {
                            deleteUser();
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("---------------------------------");
                            System.out.println("Erreur de lecture, veuillez reessayer");
                            System.out.println("---------------------------------");
                        }
                        break;
                    case 4:
                        run = false;
                        break;
                    default:
                        try {
                            showAccueil();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            System.out.println("---------------------------------");
                            System.out.println("Erreur de lecture, veuillez reessayer");
                            System.out.println("---------------------------------");
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("---------------------------------");
                            System.out.println("Erreur de lecture, veuillez reessayer");
                            System.out.println("---------------------------------");
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("---------------------------------");
                System.out.println("Erreur de lecture, veuillez reessayer");
                System.out.println("---------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("---------------------------------");
                System.out.println("Erreur de lecture, veuillez reessayer");
                System.out.println("---------------------------------");
            }
        }

        System.out.println("---------------------------------");
        System.out.println("- Good bye                      -");
        System.out.println("---------------------------------");
    }

    private static int showAccueil() throws NumberFormatException, IOException {
        System.out.println("---------------------------------");
        System.out.println("1 - Liste des utilisateurs");
        System.out.println("2 - Ajouter un utilisateur");
        System.out.println("3 - Supprimer un utilisateur");
        System.out.println("4 - Quitter");
        System.out.println("---------------------------------");
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static void showListeUser() {
        System.out.println("---------------------------------");
        System.out.println("- Liste des utilisateurs        -");
        System.out.println("---------------------------------");
        List<UserDto> listUserDto = userService.getAll();
        if (listUserDto.isEmpty()) {
            System.out.println("liste vide...");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getLogin());
            }
        }
    }

    private static void addUser() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("- Ajouter un utilisateur        -");
        System.out.println("---------------------------------");
        System.out.print(" login : ");
        boolean success = userService.add(getLoginFromInput());
        System.out.println(" Success : " + success);
    }

    private static void deleteUser() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("- Supprimer un utilisateur      -");
        System.out.println("---------------------------------");
        System.out.print(" login : ");
        boolean success = userService.delete(getLoginFromInput());
        System.out.println(" Success : " + success);
    }

    private static List<UserDto> getLoginFromInput() throws IOException {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        UserDto userDto = new UserDto();
        userDto.setLogin(bufferedReader.readLine());
        listUserDto.add(userDto);
        return listUserDto;
    }
}
