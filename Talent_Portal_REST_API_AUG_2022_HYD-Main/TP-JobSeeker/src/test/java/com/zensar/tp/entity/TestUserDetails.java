package com.zensar.tp.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.service.JobApplicationService;

public class TestUserDetails {

	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobApplicationService;
		
	    
	    @Test
	    public void testbApplicationDto() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getFirstName(),"anand");
	    }
	    
	    @Test
	    public void testbApplicationlastname() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getLastName(),"reddy");
	    }
	    
	    @Test
	    public void testbApplicationid() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getId(),2);
	    }
	    @Test
	    public void testbApplicationemail() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getEmail(),"a12@gmail.com");
	    }
	    
	    
	    @Test
	    public void testbApplicationpass() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getPassword(),"123");
	    }
	    
	    @Test
	    public void testbApplicationphone() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getPhone(),"9876543210");
	    }
	    
	    @Test
	    public void testbApplicationrole() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getRole(),"ROLE_USER");
	    }
	    
	    @Test
	    public void testbApplicationuser() throws Exception {
	        UserDetails user = new UserDetails();
	        user.setFirstName("anand");
	        user.setLastName("reddy");
	        user.setId(2);
	        user.setEmail("a12@gmail.com");
	        user.setPassword("123");
	        user.setPhone("9876543210");
	        user.setRole("ROLE_USER");
	        user.setUsername("anand123");
	        assertEquals(user.getUsername(),"anand123");
	    }
	    

}
