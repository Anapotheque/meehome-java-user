package fr.meehome.user.services;

import java.util.List;

import fr.meehome.user.services.dto.UserDto;

public interface IUserService {

    public List<UserDto> getAll();

    public List<UserDto> getUserByEmail(String email);

    public boolean isAuthorized(String email, String password);

    public boolean delete(String login);

    public boolean add(UserDto userDto);

    public boolean update(UserDto userDto);
}
