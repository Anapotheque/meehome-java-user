package fr.meehome.user.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.User;
import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

@Service(value = "IUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper Mapper;

    private List<UserDto> populateUserDto(List<User> listUser) {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        for (User user : listUser) {
            listUserDto.add(Mapper.map(user, UserDto.class));
        }
        return listUserDto;
    }

    @Override
    public List<UserDto> getAll() {
        return populateUserDto(userDao.findAll());
    }

    @Override
    public List<UserDto> getUserByLogin(String login) {
        return populateUserDto(userDao.findByLogin(login));
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        List<UserDto> listUserDto = populateUserDto(userDao.findByLoginAndPwd(login, password));
        return listUserDto != null && listUserDto.size() == 1 ? true : false;
    }

    @Override
    public void delete(List<UserDto> listUser) {
        // TODO Auto-generated method stub
    }

    @Override
    public void add(List<UserDto> listUser) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(List<UserDto> listUser) {
        // TODO Auto-generated method stub
    }
}
