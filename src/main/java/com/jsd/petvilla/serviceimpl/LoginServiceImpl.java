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
	public Login loginCustomer(String username, String password) {
		return loginRepo.findByUsernameAndPassword(username, password);
	}
}
