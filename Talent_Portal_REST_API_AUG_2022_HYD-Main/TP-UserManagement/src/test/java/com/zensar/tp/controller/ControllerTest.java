package com.zensar.tp.controller;



import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;





import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.AuthenticationRequest;
import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.entity.BlackListEntity;
import com.zensar.tp.entity.UserEntity;
import com.zensar.tp.service.LogutUserService;
import com.zensar.tp.service.RegisterUserService;
import com.zensar.tp.service.UserService;
import com.zensar.tp.utils.JwtUtils;





@WebMvcTest(UserController.class)
public class ControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RegisterUserService userService;
    @MockBean
    LogutUserService logutUserService ;
    @MockBean
    UserDetails UserDetails;
    @MockBean org.springframework.security.core.userdetails.UserDetailsService userDetailsService;
    @MockBean JwtUtils jwtutils;
    @MockBean UserService userservice;
    @MockBean AuthenticationManager authenticationManager;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void testRegisterUser() throws Exception{
        RegisterUser user = new RegisterUser();
        user.setFirstName("Anand");
        user.setLastName("Kulkarni");
        user.setUsername("anand");
        user.setPassword("anand123");
        user.setEmail("anand@gmail.com");
        user.setPhone("9999999999");
        user.setRole("ROLE_USER");
        
        
        
        when(this.userService.createNewUser(user)).thenReturn(user);
        
        MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8050/talentportal/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Anand")))
                .andReturn();
        
                String response = mvcResult.getResponse().getContentAsString();
                assertEquals(response.contains("Anand"), true);
        }
    @Test
    public void testRegisterUser1() throws Exception{
                   RegisterUser user = new RegisterUser();
                   user.setFirstName("Anand");
                   user.setLastName("Kulkarni");
                   user.setUsername("anand");
                   user.setPassword("anand123");
                   user.setEmail("anand@gmail.com");
                   user.setPhone("9999999999");
                   user.setRole("ROLE_USER");
                   
                  
                   
                   when(this.userService.createNewUser(user)).thenReturn(user);
                   
                   MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8050/talentportal/users")
                           .contentType("application/json")
                           .content(objectMapper.writeValueAsString(user)))
                           .andExpect(status().isCreated())
                           .andReturn();
                           String response = mvcResult.getResponse().getContentAsString();
                           assertEquals(response.contains("Saketh"), false);
    }
    @Test
    public void testRegisterUser3() throws Exception{
                   RegisterUser user = new RegisterUser();
                   user.setFirstName("Anand");
                   user.setLastName("Kulkarni");
                   user.setUsername("anand");
                   user.setPassword("anand123");
                   user.setEmail("anand@gmail.com");
                   user.setPhone("9999999999");
                  user.setRole("ROLE_USER");
                   
                   HttpHeaders httpHeaders = new HttpHeaders();
                   httpHeaders.set("auth-token", "ABC123");
                   
                   when(this.userService.createNewUser(user)).thenReturn(user);
                   
                   MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8050/talentportal/users")
                           .contentType("application/json")
                           .content(objectMapper.writeValueAsString(user)))
                           .andExpect(status().isCreated())
                           .andReturn();
                           String response = mvcResult.getResponse().getContentAsString();
                           assertEquals(response.contains("Saketh"), false);
    }
//    @Test
//    void addEmployeeTest() throws Exception  {
//       
//       AuthenticationRequest auth = new AuthenticationRequest("admin","admin123","admin");
//       when(this.authenticationManager.authenticate(any())).thenReturn(null);
//       when(this.jwtutils.generateToken(any())).thenReturn("djhsuidhdojiodcisj");
//       MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8050/talentportal/authenticate")
//               .contentType("application/json")
//               .content(objectMapper.writeValueAsString(auth))
//               ).andExpect(status().isOk())
//               .andReturn();
//
//
//
//
//
//     String token = mvcResult.getResponse().getContentAsString();
//       assertEquals(token.length()>0, true);
//       
//}
//    @Test
//    void addEmployeeTestUser() throws Exception  {
//        
//        AuthenticationRequest auth = new AuthenticationRequest("user","user123","user");
//        when(this.authenticationManager.authenticate(any())).thenReturn(null);
//        when(this.jwtutils.generateToken(any())).thenReturn("djhsuidhdojiodcisj");
//        MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8050/talentportal/authenticate")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(auth))
//                ).andExpect(status().isOk())
//                .andReturn();
//      String token = mvcResult.getResponse().getContentAsString();
//        assertEquals(token.length()>0, true);
//    }
    @Test
    void testgetUserById() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("authToken", "A54BG");
        String jwtToken="A54BG123";
        //RegisterUser user= new RegisterUser(1,"firstName","lastName","username", "password","email",
            //    "phone");
        List<RegisterUser> user=new ArrayList<>();
        user.add(new RegisterUser(1,"firstName","lastName","username", "password","email",
                "phone"));
        when(this.jwtutils.extractUsername(jwtToken)).thenReturn("username");
        //when(this.userService.findUserByUsername("username")).thenReturn(user);
        when(this.jwtutils.validateToken(any(),any())).thenReturn(true);
        
        MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/talentportal/home/user/1")
                .headers(httpHeaders))
                .andExpect(status().isNotFound())
                .andReturn();
               
        String response = mvcResult.getResponse().getContentAsString();
        assertEquals(response.contains("username"), false);
        }
    @Test
    void testUserController() throws Exception {
           
           String jwtToken="JwtUntils";
           
           //when(jwtToken).thenReturn(jwtToken);
           when(this.jwtutils.extractUsername("ebc12dc")).thenReturn("User");
           when(this.userDetailsService.loadUserByUsername("User")).thenReturn(null);
           when(this.jwtutils.generateToken(any())).thenReturn("ebc12dc");
           when(this.jwtutils.validateToken(any(),any())).thenReturn(true);
           MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/talentportal/token/validate"))
                   .andExpect(status().isBadRequest())
                   //.andExpect(content().string(containsString("JwtUntils")))
                   .andReturn();
           String response = mvcResult.getResponse().getContentAsString();
           assertEquals((response.contains("")), true);
       }
    @Test
    void testUserControllerp() throws Exception {
           
           String jwtToken="ebc12dc1";
           
           //when(jwtToken).thenReturn(jwtToken);
           when(this.jwtutils.extractUsername("ebc12dc1")).thenReturn("User");
           UserEntity userEntity=new UserEntity(0, "firstname", "lastname","username","123", "abc@gmail.com","987653823");
           userEntity.setRole("ROLE_ADMIN");
           List<UserEntity>userEntityList=new ArrayList<>();
           userEntityList.add(userEntity);
           when(this.userDetailsService.loadUserByUsername("User")).thenReturn(null);
           when(this.jwtutils.generateToken(any())).thenReturn("ebc12dc1");
           when(this.jwtutils.validateToken("ebc12dc1",null)).thenReturn(true);
           MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/talentportal/token/validate"))
                   .andExpect(status().isBadRequest())
                   //.andExpect(content().string(containsString("JwtUntils")))
                   .andReturn();
           String response = mvcResult.getResponse().getContentAsString();
           assertEquals((response.contains("")), true);
       }
    void testInvalidlogoutuser() throws Exception {
        BlackListEntity blackListEntity = new BlackListEntity();
        blackListEntity.setDate(LocalDate.now());
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "A1B2C3D4");
        when(this.jwtutils.extractUsername(any())).thenReturn(null);
        when(this.logutUserService.logoutUser("A1B2C3")).thenReturn(false);
        when(this.userDetailsService.loadUserByUsername(any())).thenReturn(null);
        when(this.jwtutils.validateToken(any(),any())).thenReturn(false);;
        
        MvcResult mvcResult = this.mockMvc.perform(delete("http://localhost:8050/talentportal/user/logout")
                .headers(httpHeaders))
                .andExpect(status().isBadRequest())
                .andReturn();
       String res=mvcResult.getResponse().getContentAsString();
       assertEquals(res.contains("false"), true);
        //assertEquals(res.contains("A1B2C3"), false);
        
    }
    
    @Test
    void testlogoutuser() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "ebc12dc");      
        when(this.jwtutils.extractUsername(any())).thenReturn(null);
        when(this.logutUserService.logoutUser("A1B2C3")).thenReturn(true);
        when(this.userDetailsService.loadUserByUsername(any())).thenReturn(null);
        when(this.jwtutils.validateToken(any(),any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(delete("http://localhost:8050/talentportal/user/logout")
                .headers(httpHeaders))
                .andExpect(status().isOk())
                .andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        assertEquals(res.contains("true"), true);
        
    }
    @Test
    void testlogoutuserInvaild() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "ebc12dc");      
        when(this.jwtutils.extractUsername(any())).thenReturn(null);
        when(this.logutUserService.logoutUser("A1B2C3")).thenReturn(false);
        when(this.userDetailsService.loadUserByUsername(any())).thenReturn(null);
        when(this.jwtutils.validateToken(any(),any())).thenReturn(false);
        MvcResult mvcResult = this.mockMvc.perform(delete("http://localhost:8050/talentportal/user/logout")
                .headers(httpHeaders))
                .andExpect(status().isBadRequest())
                .andReturn();
//        String res = mvcResult.getResponse().getContentAsString();
//        assertEquals(res.contains("false"), false);
        
    }
    @Test
    void testlogoutuser1() throws Exception {
        List<RegisterUser> user=new ArrayList<>();
        user.add(new RegisterUser("firstName", "lastName", "username", "password", "email","phone"));
       
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "ebc12dc976899");
        when(this.jwtutils.extractUsername("ebc12dc976899")).thenReturn("username");
        when(this.logutUserService.check("ebc12dc976899")).thenReturn(true);
        when(this.userservice.findUserByUsername("username")).thenReturn(null);
        MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/talentportal/user")
                .headers(httpHeaders))
                .andExpect(status().isBadRequest())
                .andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        assertEquals(res.contains("false"), false);
    }



   
}