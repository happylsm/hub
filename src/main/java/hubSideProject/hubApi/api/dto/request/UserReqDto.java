package hubSideProject.hubApi.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserReqDto {
	private String email;
	private String password;
}
