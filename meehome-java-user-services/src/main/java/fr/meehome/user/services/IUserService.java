package fr.meehome.user.services;

import java.util.List;

import fr.meehome.user.services.dto.User;

public interface IUserService {

    public List<User> getAll();

    public List<User> getUserByEmail(String email);

    public boolean isAuthorized(String email, String password);

    public boolean deleteById(String id);

    public boolean add(User user);

    public boolean update(User user);
}
