package fr.meehome.user.ws.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebParam;

import fr.meehome.user.ws.mapper.UserMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;

import fr.meehome.user.services.IUserService;
import fr.meehome.user.ws.IUserWS;
import fr.meehome.user.ws.dto.User;

public class UserWSImpl implements IUserWS {

	@Autowired
	private IUserService userService;

    private UserMapper mapper = Selma.builder(UserMapper.class).build();

    @Override
    public List<User> getAll() {
        return populateUserDto(userService.getAll());
    }

    @Override
    public List<User> getUserByEmail(@WebParam(name = "email") String email) {
        return populateUserDto(userService.getUserByEmail(email));
    }

    @Override
    public boolean isAuthorized(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return userService.isAuthorized(email, password);
    }

    @Override
    public boolean delete(@WebParam(name = "id") String id) {
    	return userService.deleteById(id);
    }

    private List<User> populateUserDto(List<fr.meehome.user.services.dto.User> listUserServiceDto) {
        return listUserServiceDto.stream().map(u -> mapper.asUser(u)).collect(Collectors.toList());
    }
}
