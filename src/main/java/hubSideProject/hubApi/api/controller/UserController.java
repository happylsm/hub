package hubSideProject.hubApi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hubSideProject.hubApi.api.dto.request.UserReqDto;
import hubSideProject.hubApi.api.dto.response.UserResDto;
import hubSideProject.hubApi.api.service.UserService;
import hubSideProject.hubApi.common.dto.DataResDto;
import hubSideProject.hubApi.common.exception.HubException;
import hubSideProject.hubApi.common.exception.HubExceptionCode;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    // exception 테스트용 
    @GetMapping(path = "/error")
    public DataResDto<Object> testHubException() {
        Boolean test = false;
        if (!test) {
            throw new HubException(HubExceptionCode.INTERNAL_ERROR, "Internal error");
			/*
			 { 
			 	"success": false, 
			 	"code": 20002, 
			 	"message": "Internal error - Internal error" 
			 }
			 */
        }
		
        return DataResDto.empty();
    }
	
	@ApiOperation(
			value = "회원가입"
			, notes = "회원가입을 하는 api")
	@PostMapping("/sign-up")
	public DataResDto<Object> signUP(@RequestBody UserReqDto userResDto) {
		UserResDto data = userService.signUp(userResDto);
		return DataResDto.of(data);
	}
	
	@ApiOperation(
			value = "email 중복확인"
			, notes = "email 중복확인을 하는 api")
	@GetMapping("/email-check/{email}")
	public DataResDto<Object> emailDuplicateCheck(@PathVariable("email") String email) {
		boolean result = userService.existsByEmail(email);
		if (result) {
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "이미 가입되어있는 이메일입니다.");
		} else {
			return DataResDto.of(result);
		}
	}
	
	@ApiOperation(
			value = "닉네임 중복확인"
			, notes = "닉네임 중복확인을 하는 api")
	@GetMapping("/nickname-check/{nickName}")
	public DataResDto<Object> nickNameDuplicateCheck(@PathVariable("nickName") String nickName) {
		boolean result = userService.existsByNickName(nickName);
		if (result) {
			throw new HubException(HubExceptionCode.EMAIL_DUPLICATED, "이미 가입되어있는 이메일입니다.");
		} else {
			return DataResDto.of(result);
		}
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
