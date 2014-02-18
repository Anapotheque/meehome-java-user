package fr.meehome.user.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.User;
import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper mapper;

    private List<UserDto> populateUserDto(List<User> listUser) {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        for (User user : listUser) {
            listUserDto.add(mapper.map(user, UserDto.class));
        }
        return listUserDto;
    }

    @Override
    public List<UserDto> getAll() {
        return populateUserDto(userDao.findAll());
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        return populateUserDto(userDao.findByEmail(email));
    }

    @Override
    public boolean isAuthorized(String email, String password) {
        List<UserDto> listUserDto = populateUserDto(userDao.findByEmailAndPwd(email, password));
        return listUserDto != null && listUserDto.size() == 1 ? true : false;
    }

    @Override
    public boolean delete(String email) {
        boolean result = false;
        List<User> listUserFind = userDao.findByEmail(email);
        if (listUserFind != null && !listUserFind.isEmpty()) {
            result = userDao.remove(listUserFind.get(0));
        }
        return result;
    }

    @Override
    public boolean add(UserDto userDto) {
        return userDao.save(mapper.map(userDto, User.class));
    }

    @Override
    public boolean update(UserDto userDto) {
        return userDao.save(mapper.map(userDto, User.class));
    }
}
