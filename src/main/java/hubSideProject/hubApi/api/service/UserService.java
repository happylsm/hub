package hubSideProject.hubApi.api.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	boolean existsByEmail(String email);

	boolean existsByNickName(String nickName);
	
}
