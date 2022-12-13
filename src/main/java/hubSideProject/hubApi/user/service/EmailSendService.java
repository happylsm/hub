package hubSideProject.hubApi.user.service;

import hubSideProject.hubApi.user.dto.request.EmailAuthReqDto;

public interface EmailSendService {
	boolean sendAuthCode(String toEmail);

	boolean verifyAuthCode(EmailAuthReqDto emailAuthReqDto);
}
