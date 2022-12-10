package hubSideProject.hubApi.api.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface EmailSendService {
	String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException;
}
