package hubSideProject.hubApi.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hubSideProject.hubApi.common.exception.HubException;
import hubSideProject.hubApi.common.exception.HubExceptionCode;
import hubSideProject.hubApi.user.dto.request.UserReqDto;
import hubSideProject.hubApi.user.dto.response.UserResDto;
import hubSideProject.hubApi.user.entity.UserEntity;
import hubSideProject.hubApi.user.repository.UserDetailRepository;
import hubSideProject.hubApi.user.repository.UserRepository;
import hubSideProject.hubApi.user.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);
	
	public UserRepository userRepository;
	public UserDetailRepository userDetailRepository;
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImp (UserRepository userRepository, UserDetailRepository userDetailRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userDetailRepository = userDetailRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByNickName(String nickName) {
		return userDetailRepository.existsByNickName(nickName);
	}

	@Override
	public UserResDto signUp(UserReqDto reqDto) {
		LOGGER.info("회원 가입 정보 저장");
        UserEntity user = reqDto.toEntity();
        user.encodePassword(passwordEncoder);
        UserEntity savedUser = userRepository.save(user);
        
        if (savedUser.getEmail().isEmpty()) {
        	throw new HubException(HubExceptionCode.FAIL_SIGN_UP);
        } 

		return UserResDto.of(user);
	}

}
