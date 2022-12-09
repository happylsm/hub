package hubSideProject.hubApi.api.dto.request;

import hubSideProject.hubApi.api.entity.UserEntity;
import hubSideProject.hubApi.common.HubRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {
	
    private String email;

    private String password;

    private HubRole role;

    //dto -> entity
	@Builder
    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .role(HubRole.ROLE_USER)
                .build();
    }
}
