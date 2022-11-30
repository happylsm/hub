package hubSideProject.hubApi.common.dto;

import hubSideProject.hubApi.common.exception.HubExceptionCode;

public class ErrorResDto extends BaseResDto{
	private ErrorResDto(HubExceptionCode errorCode) {
	        super(false, errorCode.getCode(), errorCode.getMessage());
	    }

	private ErrorResDto(HubExceptionCode errorCode, Exception e) {
	        super(false, errorCode.getCode(), errorCode.getMessage(e));
	    }

	private ErrorResDto(HubExceptionCode errorCode, String message) {
	        super(false, errorCode.getCode(), errorCode.getMessage(message));
	    }

	public static ErrorResDto of(HubExceptionCode errorCode) {
		return new ErrorResDto(errorCode);
	}

	public static ErrorResDto of(HubExceptionCode errorCode, Exception e) {
		return new ErrorResDto(errorCode, e);
	}

	public static ErrorResDto of(HubExceptionCode errorCode, String message) {
		return new ErrorResDto(errorCode, message);
	}
}
