package fr.meehome.user.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.meehome.user.ws.dto.UserDto;

@WebService(name = "UserService", serviceName = "UserService")
public interface IUserWS {

    public List<UserDto> getAll();

    public List<UserDto> getUserByLogin(@WebParam(name = "userLogin") String login);

    public boolean isAuthorized(@WebParam(name = "userLogin") String login, @WebParam(name = "userPassword") String password);

    public boolean delete(@WebParam(name = "userLogin") String login);

}
