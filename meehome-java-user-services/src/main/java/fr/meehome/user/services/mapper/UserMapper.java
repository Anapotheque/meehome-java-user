package fr.meehome.user.services.mapper;

import fr.meehome.user.services.dto.User;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface UserMapper {

    User asUserDto(fr.meehome.user.dao.domain.User user);

    fr.meehome.user.dao.domain.User asUser(User user);

}
