package hubSideProject.hubApi.common.dto;

import hubSideProject.hubApi.common.exception.HubExceptionCode;
import lombok.Getter;

@Getter
public class DataResDto<T> extends BaseResDto{
    private final T data;

    private DataResDto(T data) {
        super(HubExceptionCode.OK.getCode(), HubExceptionCode.OK.getMessage());
        this.data = data;
    }

    private DataResDto(T data, String message) {
        super(HubExceptionCode.OK.getCode(), message);
        this.data = data;
    }

    public static <T> DataResDto<T> of(T data) {
        return new DataResDto<>(data);
    }

    public static <T> DataResDto<T> of(T data, String message) {
        return new DataResDto<>(data, message);
    }

    public static <T> DataResDto<T> empty() {
        return new DataResDto<>(null);
    }
}
