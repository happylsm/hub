package hubSideProject.hubApi.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@DynamicUpdate
@ToString
@Table(name="userDetail")
public class UserDetailEntity {
	
	@OneToOne
	@JoinColumn(name="id")
	private UserEntity id;
	
    private String birth;
    
    private String region;
    
    @Column(unique = true)
    private String nickName;
    
    private String gender;

    @CreatedDate
	@Column(name="created_at")
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name="updated_at")
	private Date updatedAt;
}
