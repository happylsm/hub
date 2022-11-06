package hubSideProject.hubApi.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@ApiOperation(
			value = "회원가입"
			, notes = "회원가입을 하는 api")
	@GetMapping("/sign-up")
	public String signUP() {
		return "들어왓삼";
	}
	
	@ApiOperation(
			value = "email 중복확인"
			, notes = "email 중복확인을 하는 api")
	@GetMapping("/email-check")
	public String emailDuplicateCheck() {
		return "들어왓삼";
	}
	
	@ApiOperation(
			value = "닉네임 중복확인"
			, notes = "닉네임 중복확인을 하는 api")
	@GetMapping("/nickname-check")
	public String nickNameDuplicateCheck() {
		return "들어왓삼";
	}
	
	@ApiOperation(
			value = "email 인증번호 발송"
			, notes = "email 인증번호 발송을 하는 api")
	@GetMapping("/send-auth-code")
	public String sendAuthCode() {
		return "들어왓삼";
	}
	
	@ApiOperation(
			value = "email 인증번호 확인"
			, notes = "email 인증번호 확인을 하는 api")
	@GetMapping("/verify-auth-code")
	public String verifyAuthCode() {
		return "들어왓삼";
	}

}
