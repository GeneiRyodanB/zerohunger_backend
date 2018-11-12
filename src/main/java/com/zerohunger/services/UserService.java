package com.zerohunger.services;

import static com.zerohunger.config.MessageConstant.CONNECTED;
import static com.zerohunger.config.MessageConstant.MESSAGE;
import static com.zerohunger.config.MessageConstant.NEW_USER;
import static com.zerohunger.config.MessageConstant.TEL_NOT_FOUND;
import static com.zerohunger.config.MessageConstant.USER_ALREADY_EXISTS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zerohunger.models.users.User;
import com.zerohunger.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService() {
		
	}
	
	public Map<String, String> subscribe(User user) {
		Map<String, String> toSend = new HashMap<>();
		if(!checkUserIfExists(user)) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			toSend.put(MESSAGE, NEW_USER);
		}
		else {
			toSend.put(MESSAGE, USER_ALREADY_EXISTS);
		}
		return toSend;
	}
	
	public boolean checkUserIfExists(User user) {
		return (userRepository.existsByTel(user.getTel()) || userRepository.existsByEmail(user.getEmail()));
	}
	
	@Override
	public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
		User user = userRepository.findByTel(tel);
		if(user == null){
			throw new UsernameNotFoundException("Invalid tel number or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getTel(), user.getPassword(), getAuthority());
	
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	public User findByTel(String tel) {
        return userRepository.findByTel(tel);
    }
	
	public Map<String, Object> buildUserConfiguration(String tel) {
		Map<String, Object> userConfiguration = new HashMap<>();
		User user = findByTel(tel);
		userConfiguration.put("username", user.getNom());
		userConfiguration.put("email", user.getEmail());
		return userConfiguration;
	}
	
	public User getUserByTel(String tel) {
		return findByTel(tel);
	}
	
	public Map<String, Object> getUserInformation(String tel) {
		Map<String, Object> userInfo = new HashMap<>();
		User user = findByTel(tel);
		if(user != null) {
			httpSession.setAttribute("userId", user.getId());
			user.minimizeInfo();
			userInfo.put(MESSAGE, CONNECTED);
			userInfo.put("user", user);
		} 
		else {
			userInfo.put(MESSAGE, TEL_NOT_FOUND);
		}
		return userInfo;
	}

}
