package fr.meehome.user.services.mapper;

import fr.meehome.user.dao.domain.User;
import fr.meehome.user.services.dto.UserDto;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface UserMapper {

    UserDto asUserDto(User user);

    User asUser(UserDto userDto);

}
