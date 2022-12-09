package hubSideProject.hubApi.api.service;

import org.springframework.stereotype.Service;

import hubSideProject.hubApi.api.dto.request.UserReqDto;
import hubSideProject.hubApi.api.dto.response.UserResDto;

@Service
public interface UserService {

	boolean existsByEmail(String email);

	boolean existsByNickName(String nickName);
	
	UserResDto signUp(UserReqDto reqDto);
	
}
