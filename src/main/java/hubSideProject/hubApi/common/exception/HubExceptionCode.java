package hubSideProject.hubApi.common.exception;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HubExceptionCode {
    // Code format
	// 1XXXX : 회원관련 에러코드
	// 3XXXX : 게시물 관련 에러코드
    // ex) 이메일 중복 에러코드
    // EMAIL_DUPLICATED(10001, HttpStatus.BAD_REQUEST, "email duplicated"),

    OK(200, HttpStatus.OK, "Success"),
    EMAIL_DUPLICATED(10001, HttpStatus.BAD_REQUEST, "email duplicated");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage(Throwable e) {
        return this.getMessage(this.getMessage() + " - " + e.getMessage());
        // ex) "email duplicated - 이미 가입된 이메일 입니다." 
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
            .filter(Predicate.not(String::isBlank))
            .orElse(this.getMessage());
    }
}
