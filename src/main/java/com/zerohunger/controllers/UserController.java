package com.zerohunger.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerohunger.config.JwtTokenUtil;
import com.zerohunger.models.users.AuthToken;
import com.zerohunger.models.users.LoginUser;
import com.zerohunger.models.users.User;
import com.zerohunger.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    
	
	@PostMapping(path="/registration")
	public @ResponseBody Map<String, String> registration(@RequestBody User user, BindingResult bindingResult) {
		Map<String, String> result = userService.subscribe(user);
		//securityService.autologin(user.getUserName(), user.getPassword());
		return result;
	}
	
	
	@PostMapping(value = "/login")
    public @ResponseBody Map<String, Object> login(@RequestBody String tel){
        return userService.getUserInformation(tel);
    }

    @RequestMapping(value = "token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getTel(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByTel(loginUser.getTel());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
