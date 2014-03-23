package fr.meehome.user.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.meehome.user.ws.dto.UserDto;

@WebService(name = "UserService", serviceName = "UserService")
public interface IUserWS {

    public List<UserDto> getAll();

    public List<UserDto> getUserByEmail(@WebParam(name = "email") String email);

    public boolean isAuthorized(@WebParam(name = "email") String login, @WebParam(name = "password") String password);

    public boolean delete(@WebParam(name = "email") String email);

}
