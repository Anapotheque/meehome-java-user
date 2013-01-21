package fr.meehome.user.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.User;
import fr.meehome.user.services.IUserService;

public class UserServiceImplTest {

    private IUserService userService = new UserServiceImpl();

    @Mock
    private IUserDao userDaoMock;

    @Mock
    private Mapper mapperMock;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(userService, "userDao", userDaoMock, IUserDao.class);
        ReflectionTestUtils.setField(userService, "mapper", mapperMock, Mapper.class);

        // gestion des mocks
        when(userDaoMock.findAll()).thenReturn(populate_users_dao_mock());
        when(userDaoMock.findByLoginAndPwd("test1", "pwd1")).thenReturn(populate_user_dao_mock());
        when(userDaoMock.findByLogin("test1")).thenReturn(populate_user_dao_mock());
    }

    private List<User> populate_users_dao_mock() {
        List<User> listUser = new ArrayList<User>();
        User user1 = new User();
        user1.setLogin("test1");
        user1.setPassword("pwd1");
        User user2 = new User();
        user2.setLogin("test2");
        user2.setPassword("pwd2");
        listUser.add(user1);
        listUser.add(user2);
        return listUser;
    }

    private List<User> populate_user_dao_mock() {
        List<User> listUser = new ArrayList<User>();
        User user1 = new User();
        user1.setLogin("test1");
        user1.setPassword("pwd1");
        listUser.add(user1);
        return listUser;
    }

    @Test
    public void should_return_all_users() {
        assertEquals(2, userService.getAll().size());
    }

    @Test
    public void should_return_one_users_by_login() {
        assertEquals(1, userService.getUserByLogin("test1").size());
    }

    @Test
    public void should_return_true_for_authorization() {
        assertEquals(true, userService.isAuthorized("test1", "pwd1"));
    }
}
