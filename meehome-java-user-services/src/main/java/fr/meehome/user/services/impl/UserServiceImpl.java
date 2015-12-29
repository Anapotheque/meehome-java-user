package fr.meehome.user.services.impl;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;
import fr.meehome.user.services.mapper.UserMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    private UserMapper mapper = Selma.builder(UserMapper.class).build();

    @Override
    public List<UserDto> getAll() {
        return asListUserDto(userDao.findAll());
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        return asListUserDto(userDao.findByEmail(email));
    }

    @Override
    public boolean isAuthorized(String email, String password) {
        return userDao.findByEmailAndPwd(email, password).stream().findFirst().isPresent();
    }

    @Override
    public boolean deleteById(String id) {
        Optional<fr.meehome.user.dao.domain.User> user = userDao.findById(id).stream().findFirst();
        if(user.isPresent()){
            return userDao.remove(user.get());
        }
        return false;
    }

    @Override
    public boolean add(UserDto userDto) {
        return userDao.save(mapper.asUser(userDto));
    }

    @Override
    public boolean update(UserDto userDto) {
        return userDao.save(mapper.asUser(userDto));
    }

    private List<UserDto> asListUserDto(List<fr.meehome.user.dao.domain.User> listUser) {
        return  listUser.stream().map(u -> mapper.asUserDto(u)).collect(Collectors.toList());
    }
}
