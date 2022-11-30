package hubSideProject.hubApi.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hubSideProject.hubApi.api.repository.UserRepository;
import hubSideProject.hubApi.api.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean emailDuplicateCheck(String email) {
		return userRepository.existsByEmail(email);
	}

}
