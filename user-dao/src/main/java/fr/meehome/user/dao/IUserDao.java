package fr.meehome.musculation.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.musculation.dao.domain.RoleEnum;
import fr.meehome.musculation.dao.domain.User;

public interface IUserDao extends GenericDAO<User, Long> {

	public List<User> findByLogin(String login);

	public List<User> findByRole(RoleEnum roleEnum);

}
