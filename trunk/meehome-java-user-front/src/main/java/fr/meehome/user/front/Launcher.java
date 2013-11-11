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

        System.out.println("---------------------------------");
        System.out.println("- Welcome                        ");
        System.out.println("---------------------------------");

        while (run) {
            try {
                switch (accueil()) {
                    case 1:
                        showAll();
                        break;
                    case 2:
                        newUser();
                        break;
                    case 3:
                        recherche();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        try {
                            accueil();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            printError();
                        } catch (IOException e) {
                            e.printStackTrace();
                            printError();
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                printError();
            } catch (IOException e) {
                e.printStackTrace();
                printError();
            }
        }

        System.out.println("---------------------------------");
        System.out.println("- Good bye                       ");
        System.out.println("---------------------------------");
    }

    private static int accueil() throws NumberFormatException, IOException {
        System.out.println("---------------------------------");
        System.out.println("1 - Liste des users");
        System.out.println("2 - Nouveau user");
        System.out.println("3 - Recherche user par login");
        System.out.println("4 - Suprression user par login");
        System.out.println("5 - Quitter");
        System.out.println("---------------------------------");
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static void showAll() {
        System.out.println("---------------------------------");
        System.out.println("- Liste des users                ");
        System.out.println("---------------------------------");
        List<UserDto> listUserDto = userService.getAll();
        if (listUserDto.isEmpty()) {
            System.out.println("- Aucun user");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getNom() + " - " + userDto.getPrenom() + " - " + userDto.getLogin());
            }
        }
    }

    private static void recherche() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("- Recherche users :              ");
        System.out.println("---------------------------------");
        System.out.println("- Login : ");
        String login = bufferedReader.readLine();
        List<UserDto> listUserDto = userService.getUserByLogin(login);
        System.out.println("---------------------------------");
        if (listUserDto.isEmpty()) {
            System.out.println("- Aucun user");
        } else {
            for (UserDto userDto : listUserDto) {
                System.out.println(userDto.getNom() + " - " + userDto.getPrenom() + " - " + userDto.getLogin());
            }
        }
    }

    private static void delete() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("- Suppression user par Login     ");
        System.out.println("---------------------------------");
        System.out.println("- Login : ");
        String login = bufferedReader.readLine();

        System.out.println("---------------------------------");
        System.out.print("- Suppression user ");
        if (userService.delete(login)) {
            System.out.println("[OK]");
        } else {
            System.out.println("[ECHEC]");
        }
    }

    private static void newUser() throws NumberFormatException, IOException {
        System.out.println("---------------------------------");
        System.out.println("- Nouveau user                   ");
        System.out.println("---------------------------------");
        System.out.println("- Nom : ");
        String nom = bufferedReader.readLine();

        System.out.println("- Prenom : ");
        String prenom = bufferedReader.readLine();

        System.out.println("- Login : ");
        String login = bufferedReader.readLine();

        System.out.println("- Mot de passe : ");
        String password = bufferedReader.readLine();

        UserDto userDto = new UserDto();
        userDto.setNom(nom);
        userDto.setPrenom(prenom);
        userDto.setLogin(login);
        userDto.setPassword(password);

        System.out.println("---------------------------------");
        System.out.print("- Ajout user ");
        if (userService.add(userDto)) {
            System.out.println("[OK]");
        } else {
            System.out.println("[ECHEC]");
        }
    }

    private static void printError() {
        System.out.println("---------------------------------");
        System.out.println("Erreur de lecture, veuillez reessayer");
        System.out.println("---------------------------------");
    }
}
