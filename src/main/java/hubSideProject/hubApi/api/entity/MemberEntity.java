package hubSideProject.hubApi.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@DynamicUpdate
@ToString
@Table(name="member")
public class MemberEntity {

	@Version
    private Long _version;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String email;
    
    private String birth;
    
    private String password;
    
    private String region;
    
    @Column(unique = true)
    private String nickName;
    
    private String userStatus;
    
    private String gender;
    
    @CreatedDate
	@Column(name="created_at")
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name="updated_at")
	private Date updatedAt;

}
