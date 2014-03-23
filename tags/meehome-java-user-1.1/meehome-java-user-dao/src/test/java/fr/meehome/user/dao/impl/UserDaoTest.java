package fr.meehome.user.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.RoleEnum;
import fr.meehome.user.dao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/user/dao/applicationContext-test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(value = "UserDao.xml")
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IUserDao userDao;

    @Test
    public void should_return_all_users() {
        List<User> listUsers = userDao.findAll();
        Assert.assertEquals(2, listUsers.size());
    }

    @Test
    public void should_return_one_user_by_email() {
        List<User> listUsers = userDao.findByEmail("email1");
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_return_one_user_by_role() {
        List<User> listUsers = userDao.findByRole(RoleEnum.ADMINISTRATEUR);
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_update_one_user_by_email() {
        List<User> listUsers = userDao.findByEmail("email1");
        listUsers.get(0).setEmail("email3");
        userDao.save(listUsers.get(0));
        listUsers = userDao.findByEmail("email3");
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_delete_one_user_by_email() {
        userDao.remove(userDao.findByEmail("email1").get(0));
        Assert.assertEquals(1, userDao.findAll().size());
    }

    @Test
    public void should_delete_all_users_by_email() {
        for (User user : userDao.findAll()) {
            userDao.remove(user);
        }
        Assert.assertEquals(0, userDao.findAll().size());
    }

    @Test
    public void should_insert_one_user() {
        User user = new User();
        user.setEmail("email3");
        userDao.save(user);
        Assert.assertEquals(3, userDao.findAll().size());
    }
}
