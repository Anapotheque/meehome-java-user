package fr.meehome.user.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.meehome.user.services.IUserService;
import fr.meehome.user.ws.dto.UserDto;

public class UserWSImpl implements IUserWS {

	@Autowired
	private IUserService userService;
	
	@Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper mapper;

    private List<UserDto> populateUserDto(List<fr.meehome.user.services.dto.UserDto> listUserServiceDto) {
        List<UserDto> listUserWsDto = new ArrayList<UserDto>();
        for (fr.meehome.user.services.dto.UserDto userServiceDto : listUserServiceDto) {
        	listUserWsDto.add(mapper.map(userServiceDto, UserDto.class));
        }
        return listUserWsDto;
    }
	
    @Override
    public List<UserDto> getAll() {
        return populateUserDto(userService.getAll());
    }

    @Override
    public List<UserDto> getUserByEmail(@WebParam(name = "email") String email) {
        return populateUserDto(userService.getUserByEmail(email));
    }

    @Override
    public boolean isAuthorized(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return userService.isAuthorized(email, password);
    }

    @Override
    public boolean delete(@WebParam(name = "email") String email) {
    	return userService.delete(email);
    }
}
