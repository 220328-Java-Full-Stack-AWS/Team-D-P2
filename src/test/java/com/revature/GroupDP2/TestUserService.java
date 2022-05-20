package com.revature.GroupDP2;

import com.revature.GroupDP2.exceptions.InvalidEmailException;
import com.revature.GroupDP2.exceptions.UnableException;
import com.revature.GroupDP2.exceptions.UnauthorizedException;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import com.revature.GroupDP2.services.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUserService {
    @MockBean(UserRepository.class)
    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    private User tu1;
    private User tu2;

    @BeforeEach
    public void before(){
        userService=new UserService(userRepository);
        tu1=new User("username","password",true,"John","Test",
                "EMAIL@EMAIL.COM","phone","street","city","state","zip");
        tu2=new User("wrong","wrong",true,"Mark","Test",
                "EMAIL@EMAIL.COM","phone","street","city","state","zip");
    }
    @AfterAll
    public static void afterC(){

    }
    @AfterEach
    public void after(){

    }

    @Test
    public void testUserRegisterSuccess() throws Exception {
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        userService.register(tu1);
    }
    @Test
    public void testUserRegisterFailAlreadyInsertedUser(){
        //I took this code from online =-)
        when(userRepository.getByUsername("username")).thenReturn(Optional.of(tu1));
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.register(tu1);
        });
        Assertions.assertEquals("username already taken!", thrown.getMessage());
    }
    @Test
    public void testUserRegisterFailBadEmail(){
        tu1.setEmail("BADBADEMAIL.NONSENSE");
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.register(tu1);
        });
        Assertions.assertEquals("email invalid!", thrown.getMessage());
    }
    @Test
    public void testLoginSuccess() throws Exception {
        when(userRepository.getByUsername("username")).thenReturn(Optional.of(tu1));
        Assertions.assertEquals(userService.login(tu1),tu1);
    }
    @Test
    public void testLoginFailure(){
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        Assertions.assertThrows(UnauthorizedException.class, () -> {
            userService.login(tu1);
        });
    }
    @Test
    public void testEditSuccessWhileNotUpdateing() throws Exception{
        tu1.setId(5);
        when(userRepository.getById(5)).thenReturn(Optional.of(tu1));
        Assertions.assertEquals(userService.edit(tu1),tu1);
    }
    @Test
    public void testEditSuccessWhileUpdating() throws Exception {
        tu1.setId(5);
        when(userRepository.getById(5)).thenReturn(Optional.of(tu1));
        User tu3= new User("newUsername","password",true,"John","Test",
                "EMAIL@EMAIL.COM","phone","street","Hudson","state","zip");
        tu3.setId(5);
        User out =userService.edit(tu3);
        Assertions.assertEquals(out.toString(),tu3.toString());
    }
    @Test
    public void testEditFailureBadEmail(){
        when(userRepository.getById(5)).thenReturn(Optional.of(tu1));
        tu2.setId(5);
        tu2.setEmail("BADEMAIL");
        Assertions.assertThrows(InvalidEmailException.class, () -> {
            userService.edit(tu2);
        });
    }
    @Test
    public void testEditFailBadID(){
        when(userRepository.getById(5)).thenReturn(Optional.empty());
        tu2.setId(5);
        Assertions.assertThrows(UnableException.class, () -> {
            userService.edit(tu2);
        });
    }
    @Test
    public void testUnRegesterSuccess() throws Exception {
        when(userRepository.getByUsername("username")).thenReturn(Optional.of(tu1));
        Assertions.assertEquals(tu1,userService.unregister(tu1));
    }
    @Test
    public void testUnRegesterFailure(){
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        Assertions.assertThrows(UnableException.class, () -> {
            userService.unregister(tu1);
        });

    }
}
