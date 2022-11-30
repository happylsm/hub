package hubSideProject.hubApi.api.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	boolean emailDuplicateCheck(String email);
	
}
