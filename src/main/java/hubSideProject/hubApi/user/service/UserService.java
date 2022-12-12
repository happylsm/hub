package hubSideProject.hubApi.user.service;

import org.springframework.stereotype.Service;

import hubSideProject.hubApi.user.dto.request.UserReqDto;
import hubSideProject.hubApi.user.dto.response.UserResDto;

@Service
public interface UserService {

	boolean existsByEmail(String email);

	boolean existsByNickName(String nickName);
	
	UserResDto signUp(UserReqDto reqDto);
	
}
