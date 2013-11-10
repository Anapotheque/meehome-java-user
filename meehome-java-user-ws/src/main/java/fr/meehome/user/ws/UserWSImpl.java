package fr.meehome.user.ws;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebParam;

import fr.meehome.user.ws.dto.UserDto;

public class UserWSImpl implements IUserWS {

    @Override
    public List<UserDto> getAll() {
        UserDto userDto = new UserDto();
        userDto.setNom("test");
        userDto.setPrenom("test");
        return Arrays.asList(userDto);
    }

    @Override
    public List<UserDto> getUserByLogin(@WebParam(name = "userLogin") String login) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAuthorized(@WebParam(name = "userLogin") String login, @WebParam(name = "userPassword") String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(@WebParam(name = "userLogin") String login) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
