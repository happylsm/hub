package hubSideProject.hubApi.user.dto.request;

import hubSideProject.hubApi.common.hubEnum.HubRole;
import hubSideProject.hubApi.user.entity.UserEntity;
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
    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .role(HubRole.ROLE_USER)
                .build();
    }
}
