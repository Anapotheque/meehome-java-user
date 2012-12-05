package fr.meehome.musculation.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Search;

import fr.meehome.musculation.dao.IUserDao;
import fr.meehome.musculation.dao.domain.RoleEnum;
import fr.meehome.musculation.dao.domain.User;

@Repository
public class UserDao extends SessionFactoryDao<User, Long> implements IUserDao {

    @Override
    public List<User> findByLogin(String login) {
        return search(new Search().addFilterEqual("login", login));
    }

    @Override
    public List<User> findByRole(RoleEnum roleEnum) {
        return search(new Search().addFilterEqual("roleEnum", roleEnum));
    }
}
