package hubSideProject.hubApi.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hubSideProject.hubApi.api.repository.UserDetailRepository;
import hubSideProject.hubApi.api.repository.UserRepository;
import hubSideProject.hubApi.api.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByNickName(String nickName) {
		return userDetailRepository.existsByNickName(nickName);
	}

}
