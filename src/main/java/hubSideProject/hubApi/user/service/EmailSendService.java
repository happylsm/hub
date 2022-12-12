package hubSideProject.hubApi.user.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface EmailSendService {
	String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException;
}
