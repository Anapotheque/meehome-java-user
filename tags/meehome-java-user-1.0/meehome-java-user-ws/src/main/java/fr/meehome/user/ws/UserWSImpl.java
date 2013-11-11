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
    public List<UserDto> getUserByLogin(@WebParam(name = "userLogin") String login) {
        return populateUserDto(userService.getUserByLogin(login));
    }

    @Override
    public boolean isAuthorized(@WebParam(name = "userLogin") String login, @WebParam(name = "userPassword") String password) {
        return userService.isAuthorized(login, password);
    }

    @Override
    public boolean delete(@WebParam(name = "userLogin") String login) {
    	return userService.delete(login);
    }
}
