package hubSideProject.hubApi.common.exception;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.Arrays;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HubExceptionCode {
    /*	Code format
     *  1XXXX : 회원관련 에러코드
     *  3XXXX : 게시물 관련 에러코드
     *  ex) 이메일 중복 에러코드
     *  EMAIL_DUPLICATED(10001, HttpStatus.BAD_REQUEST, "email duplicated")
     */

    OK(200, HttpStatus.OK, "Success"),
    BAD_REQUEST(20001, HttpStatus.BAD_REQUEST, "Bad request"),
    INTERNAL_ERROR(20002, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error"),
    
    EMAIL_DUPLICATED(10001, HttpStatus.BAD_REQUEST, "email duplicated"),
	FAIL_SIGN_UP(10002, HttpStatus.BAD_REQUEST, "fail sign up");

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

    public static HubExceptionCode valueOf(HttpStatus httpStatus) {
        if (httpStatus == null) {
            throw new HubException("HttpStatus is null.");
        }

        return Arrays.stream(values())
            .filter(errorCode -> errorCode.getHttpStatus() == httpStatus)
            .findFirst()
            .orElseGet(() -> {
                if (httpStatus.is4xxClientError()) {
                    return HubExceptionCode.BAD_REQUEST;
                } else if (httpStatus.is5xxServerError()) {
                    return HubExceptionCode.INTERNAL_ERROR;
                } else {
                    return HubExceptionCode.OK;
                }
            });
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.name(), this.getCode());
    }
}
