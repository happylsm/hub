package hubSideProject.hubApi.user.service.impl;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import hubSideProject.hubApi.common.exception.HubException;
import hubSideProject.hubApi.common.exception.HubExceptionCode;
import hubSideProject.hubApi.common.util.RedisUtil;
import hubSideProject.hubApi.user.dto.request.EmailAuthReqDto;
import hubSideProject.hubApi.user.service.EmailSendService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailSendServiceImp implements EmailSendService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmailSendServiceImp.class);

    private final JavaMailSender emailSender;
    private final RedisUtil redisUtil;
    
    private String authNum;
    
    @Value("${spring.mail.username}")
    private String hubEmail;

    public void createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i=0;i<6;i++) {
            int index = random.nextInt(3);

            switch (index) {
                case 0 :
                    key.append((char) ((int)random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) ((int)random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        authNum = key.toString();
    }

    public MimeMessage createEmailForm(String email) {

    	MimeMessage message = emailSender.createMimeMessage();
    	
        createCode();
        String setFrom = hubEmail;
        String toEmail = email;
        
     	try {
			message.addRecipients(MimeMessage.RecipientType.TO, toEmail);
			message.setSubject("hub 회원가입 인증메일");//제목
	        String msgg="";
	        msgg+= "<div style='margin:100px;'>";
	       	msgg+= "<h3> 안녕하세요  hub 입니다 </h3>";
	        msgg+= "<br>";
	        msgg+= "<p>본인 확인을 위하여 아래의 인증번호를 확인하신 후 회원 가입 창에 입력하여 주시기바랍니다.<p>";
	        msgg+= "<br>";
	        msgg+= "<br>";
			msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
			msgg+= "<h3 style='color:blue;'>인증번호</h3>";
			msgg+= "CODE : <strong>";
			msgg+= authNum+"</strong><div><br/> ";
			msgg+= "</div>";
	        message.setText(msgg, "utf-8", "html");
	        
	        message.setFrom(setFrom);
		} catch (MessagingException e) {
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "메일 전송에 실패했습니다.");
		}

        return message;
    }

    @Override
    public boolean sendAuthCode(String toEmail) {
        try {
            MimeMessage emailForm = createEmailForm(toEmail);
        	redisUtil.setDataExpire(authNum, toEmail, 60 * 5L);
        	emailSender.send(emailForm);
        } catch (HubException e) { 
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "메일 전송에 실패했습니다.");
        };
        
        return true;
    }

	@Override
	public boolean verifyAuthCode(EmailAuthReqDto emailAuthReqDto) {
		String email = redisUtil.getData(emailAuthReqDto.getAuthCode());
        
		if (email == null) {
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "인증에 실패했습니다.");
		} else if (!email.equals(emailAuthReqDto.getEmail())) {
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "인증에 실패했습니다.");
		}
        
		return true;
	}

}