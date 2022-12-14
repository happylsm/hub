package hubSideProject.hubApi.user.dto.response;

import hubSideProject.hubApi.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
	
	private String email;

    //entity -> dto
    public static UserResDto of(UserEntity userEntity){
        return UserResDto.builder()
                .email(userEntity.getEmail())
                .build();
    }
}
