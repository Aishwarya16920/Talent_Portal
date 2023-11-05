package com.zensar.tp.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({UserEntity.class,BlackListEntity.class})
public class EntityTest {
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    UserDetailsService userDetailsService;
    
    @Test
    public void testUserEntityByLastname() throws Exception{
        UserEntity user=new UserEntity();
        user.setFirstName("Anand");
        user.setLastName("Kulkarni");
        user.setUsername("anand");
        user.setPassword("anand123");
        user.setEmail("anand@gmail.com");
        user.setPhone("9999999999");
        user.setRole("ROLE_ADMIN");
        assertEquals(user.getRole(),"ROLE_ADMIN");
    }
    
    @Test
    public void testUserEntityByFirstname() throws Exception{
        UserEntity user=new UserEntity();
        user.setFirstName("Bindu");
        user.setLastName("Madhavi");
        user.setUsername("bindu");
        user.setPassword("bindu123");
        user.setEmail("bindu@gmail.com");
        user.setRole("ROLE_USER");
        assertEquals("Bindu", user.getFirstName());
    }
    
    @Test
    public void testUserEntityByUsername() throws Exception{
        UserEntity user=new UserEntity();
        user.setFirstName("Bindu");
        user.setLastName("Madhavi");
        user.setUsername("bindu");
        user.setPassword("bindu123");
        user.setEmail("bindu@gmail.com");
        user.setPhone("9999999999");
        user.setRole("ROLE_USER");
        assertEquals("bindu", user.getUsername());
    }



   @Test
    public void testGetParameterisedArguments() throws Exception{
        UserEntity user =  new UserEntity("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
        user.setRole("ROLE_ADMIN");
        assertEquals("anand",user.getFirstName());
        assertEquals("kulkarni",user.getLastName());
        assertEquals("anand",user.getUsername());
        assertEquals("9999999999",user.getPhone());
        assertEquals("anand123",user.getPassword());
        assertEquals("ROLE_ADMIN",user.getRole());
        
    }
   @Test
   public void testGetBlackListEntity() throws Exception{
	   BlackListEntity user =  new BlackListEntity(1,"123456",LocalDate.now());
       assertEquals(1,user.getId());
       assertEquals("123456",user.getAuth());
       assertEquals(user.getDate(),user.getDate());
      
       
   }
   @Test
   public void testSetBlackListEntity() throws Exception{
	   BlackListEntity user =  new BlackListEntity();
	   user.setId(1);
	   user.setAuth("123456");
	   user.setDate(LocalDate.now());
       assertEquals(1,user.getId());
       assertEquals("123456",user.getAuth());
       assertEquals(user.getDate(),user.getDate());
      
       
   }
    



}
