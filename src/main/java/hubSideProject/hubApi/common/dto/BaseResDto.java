package hubSideProject.hubApi.common.dto;

import hubSideProject.hubApi.common.exception.HubExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class BaseResDto {
    private final Boolean success;
    private final Integer code;
    private final String message;

    public static BaseResDto of(Boolean success, HubExceptionCode code) {
        return new BaseResDto(success, code.getCode(), code.getMessage());
    }

    public static BaseResDto of(Boolean success, HubExceptionCode errorCode, Exception e) {
        return new BaseResDto(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static BaseResDto of(Boolean success, HubExceptionCode errorCode, String message) {
        return new BaseResDto(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}
