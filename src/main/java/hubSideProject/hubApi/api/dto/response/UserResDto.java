package hubSideProject.hubApi.api.dto.response;

import java.util.Date;

import hubSideProject.hubApi.api.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {
	private long id;
	private String email;
	private String password;
	private Date createdAt;
	private Date updatedAt;
    
    @Builder
    public UserResDto(long id, String email, String password, Date createdAt, Date updatedAt){
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    //dto -> entity
    public UserEntity toEntity(){
        return UserEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
