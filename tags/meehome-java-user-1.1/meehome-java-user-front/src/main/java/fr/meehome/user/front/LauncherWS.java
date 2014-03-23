package fr.meehome.user.front;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import fr.meehome.user.ws.UserDto;
import fr.meehome.user.ws.UserService;

public class LauncherWS {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8080/meehome-java-user-ws/services/user?wsdl");
        factory.setServiceClass(UserService.class);

        UserService userService = (UserService ) factory.create();
        List<UserDto> list = userService.getAll();
        if (list != null) {
            for (UserDto userDto : list) {
                System.out.println(userDto.getNom() + " - " + userDto.getPrenom() + " - " + userDto.getEmail());
            }
        } else {
            System.out.println("liste vide");
        }
    }
}
