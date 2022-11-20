package hubSideProject.hubApi.common.exception;

import lombok.Getter;

@Getter
public class HubException extends RuntimeException{
	/**
	 * to-do 
	 */
	private static final long serialVersionUID = 1L;
	private final HubExceptionCode errorCode;
    
    public HubException(HubExceptionCode errorCode, String message) {
        super(errorCode.getMessage(message));
        this.errorCode = errorCode;
    }
}
