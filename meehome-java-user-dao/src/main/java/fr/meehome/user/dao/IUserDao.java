package fr.meehome.user.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.user.dao.domain.RoleEnum;
import fr.meehome.user.dao.domain.User;

public interface IUserDao extends GenericDAO<User, Long> {

    public List<User> findByEmailAndPwd(String email, String password);

    public List<User> findByEmail(String email);

    public List<User> findByRole(RoleEnum roleEnum);

}
