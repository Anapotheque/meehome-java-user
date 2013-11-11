package fr.meehome.user.services;

import java.util.List;

import fr.meehome.user.services.dto.UserDto;

public interface IUserService {

    public List<UserDto> getAll();

    public List<UserDto> getUserByLogin(String login);

    public boolean isAuthorized(String login, String password);

    public boolean delete(String login);

    public boolean add(UserDto userDto);

    public boolean update(UserDto userDto);
}
