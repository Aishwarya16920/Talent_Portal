package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.exceptions.InvalidUserDataException;





@WebMvcTest({AuthenticationRequest.class,RegisterUser.class})
public class DtoTest {
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    UserDetailsService userDetailsService;
    
    @Test
    public void testGetUserDTOReturnsCorrectJson() throws Exception {
    	RegisterUser user = new RegisterUser();
        user.setFirstName("anand");
        user.setLastName("Kulkarni");
        user.setUsername("anand");
        user.setPassword("anand123");
        user.setEmail("anand@gmail.com");
        user.setPhone("9999999999");
        user.setRole("ROLE_ADMIN");
        
        assertEquals(user.getFirstName(),"anand");
    }
    @Test
    public void UserDtoGetting() throws Exception{
    	Userdto user =  new Userdto("token","user","role");
        assertEquals(user.getToken(),"token");
        assertEquals(user.getUsername(),"user");
        assertEquals(user.getRole(),"role");
        
    }
    @Test
    public void UserDtoSetting() throws Exception{
    	Userdto user =  new Userdto("token","user","role");
    	user.setToken("token");
    	user.setUsername("user");
    	user.setRole("role");
        assertEquals(user.getToken(),"token");
        assertEquals(user.getUsername(),"user");
        assertEquals(user.getRole(),"role");
        
    }
    @Test
    public void testGetParameterised() throws Exception{
    	RegisterUser user =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
        assertEquals(user.getFirstName(),"anand");
        assertEquals(user.getLastName(),"kulkarni");
        assertEquals(user.getUsername(),"anand");
        //assertEquals(user.getPhone(),"9999999999");
        assertEquals(user.getPassword(),"anand123");
        //assertEquals(user.getPhone(),"ROLE_ADMIN");
        
    }
    
    @Test
    public void testGetParameterisedArguments() throws Exception{
    	RegisterUser user =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
        assertEquals(user.getFirstName(),"anand");
        assertEquals(user.getLastName(),"kulkarni");
        assertEquals(user.getUsername(),"anand");
        //assertEquals(user.getPhone(),"9999999999");
        assertEquals(user.getPassword(),"anand123");
        //assertEquals(user.getPhone(),"ROLE_ADMIN");
        
    }
    @Test
    
    public void AuthenticationRequesttest() throws Exception{
    	AuthenticationRequest auth=new AuthenticationRequest("username","password","ROLE_ADMIN");
    	assertEquals(auth.getUsername(),"username");
    }
@Test
    
    public void AuthenticationSettest() throws Exception{
    	AuthenticationRequest auth=new AuthenticationRequest("username","password","ROLE_ADMIN");
    	auth.setUsername("username");
    	auth.setPassword("passeord");
    	auth.setRole("ROLE_ADMIN");
    	assertEquals(auth.getUsername(),"username");
    }
@Test
void testCandidateDtoEquals1() {
	RegisterUser user1 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
	RegisterUser user2 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
assertTrue(user1.equals(user2));
}
@Test
void testCandidateDtoEquals2() {
	RegisterUser user1 =  new RegisterUser("admin","kulkarni","anand","anand123","anand@gmail.com","9999999999");
	AuthenticationRequest auth=new AuthenticationRequest("username","password","ROLE_ADMIN");
assertFalse(user1.equals(auth));
}

@Test
void testCandidateDtoEquals3() {
	RegisterUser user1 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
	RegisterUser user2 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
assertTrue(user1.equals((user2)));
}
@Test
void testCandidateDtoEquals4() {
	RegisterUser user1 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
	RegisterUser user2 =  new RegisterUser("anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
assertEquals(user1.getUsername(),(user2).getUsername());
}
@Test
void testCandidateDtoEquals5() {
	RegisterUser user1 =  new RegisterUser(0,null,null,null,null,null, null);
	RegisterUser user2 =  new RegisterUser(1,"anand","kulkarni","anand","anand123","anand@gmail.com","9999999999");
assertFalse(user1.equals(user2));
}
@Test
void testtoString() {
String message="message";//InvalidUserDataException.class
String msg=message.toString();
assertEquals(message,msg);
}
}