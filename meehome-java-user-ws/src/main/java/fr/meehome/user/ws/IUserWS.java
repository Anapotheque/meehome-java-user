package fr.meehome.user.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.meehome.user.ws.dto.User;

@WebService(name = "UserService", serviceName = "UserService")
public interface IUserWS {

    public List<User> getAll();

    public List<User> getUserByEmail(@WebParam(name = "email") String email);

    public boolean isAuthorized(@WebParam(name = "email") String login, @WebParam(name = "password") String password);

    public boolean delete(@WebParam(name = "email") String email);

}
