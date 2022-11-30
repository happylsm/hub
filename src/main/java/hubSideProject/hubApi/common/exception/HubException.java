package hubSideProject.hubApi.common.exception;

import lombok.Getter;

@Getter
public class HubException extends RuntimeException{
	/**
	 * to-do 
	 */
	private static final long serialVersionUID = 1L;
	private final HubExceptionCode errorCode;
    
	public HubException() {
        super(HubExceptionCode.INTERNAL_ERROR.getMessage());
        this.errorCode = HubExceptionCode.INTERNAL_ERROR;
    }

    public HubException(String message) {
        super(HubExceptionCode.INTERNAL_ERROR.getMessage(message));
        this.errorCode = HubExceptionCode.INTERNAL_ERROR;
    }

    public HubException(String message, Throwable cause) {
        super(HubExceptionCode.INTERNAL_ERROR.getMessage(message), cause);
        this.errorCode = HubExceptionCode.INTERNAL_ERROR;
    }

    public HubException(Throwable cause) {
        super(HubExceptionCode.INTERNAL_ERROR.getMessage(cause));
        this.errorCode = HubExceptionCode.INTERNAL_ERROR;
    }

    public HubException(HubExceptionCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HubException(HubExceptionCode errorCode, String message) {
        super(errorCode.getMessage(message));
        this.errorCode = errorCode;
    }

    public HubException(HubExceptionCode errorCode, String message, Throwable cause) {
        super(errorCode.getMessage(message), cause);
        this.errorCode = errorCode;
    }

    public HubException(HubExceptionCode errorCode, Throwable cause) {
        super(errorCode.getMessage(cause), cause);
        this.errorCode = errorCode;
    }
}
