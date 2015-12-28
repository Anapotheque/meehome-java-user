package fr.meehome.user.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Search;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.RoleEnum;
import fr.meehome.user.dao.domain.User;

@Repository
public class UserDao extends SessionFactoryDao<User, Long> implements IUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Override
    public List<User> findByEmailAndPwd(String email, String password) {
        LOGGER.debug("Recherche user par email et password : " + email + "- " + password);
        return search(new Search().addFilterEqual("email", email).addFilterEqual("password", password));
    }

    @Override
    public List<User> findById(String id) {
        LOGGER.debug("Recherche user par identifiant : " + id);
        return search(new Search().addFilterEqual("id", id));
    }

    @Override
    public List<User> findByEmail(String email) {
        LOGGER.debug("Recherche user par email : " + email);
        return search(new Search().addFilterLike("email", email));
    }

    @Override
    public List<User> findByRole(RoleEnum roleEnum) {
        LOGGER.debug("Recherche user par role : " + roleEnum.getLibelle());
        return search(new Search().addFilterEqual("roleEnum", roleEnum));
    }
}
