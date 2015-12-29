package fr.meehome.user.ws.mapper;

import fr.meehome.user.services.dto.UserDto;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface UserMapper {

    fr.meehome.user.ws.dto.User asUser(UserDto userDto);

}
