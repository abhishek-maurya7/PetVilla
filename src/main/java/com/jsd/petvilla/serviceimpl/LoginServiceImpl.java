package com.jsd.petvilla.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.Login;
import com.jsd.petvilla.repository.LoginRepository;
import com.jsd.petvilla.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	@Override
	public Login loginUser(String username, String password, String token) {
		Login credentials = loginRepo.findByUsernameAndPassword(username, password);
		credentials.setToken(token);
		loginRepo.save(credentials);
		return loginRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public String registerUser(Login credientials) {
		 loginRepo.save(credientials);
		 return "User has been created. You can login now.";
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		return !loginRepo.existsByUsername(username);
	}
}
