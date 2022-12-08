package hubSideProject.hubApi.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@DynamicUpdate
@ToString
@Table(name="user_detail")
public class UserDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @Column(name = "nickname", unique = true)
    private String nickName;
	
	@Column(name="birth")
    private String birth;
    
	@Column(name="region")
    private String region;
    
    @Column(name="gender")
    private String gender;

    @CreatedDate
	@Column(name="created_at")
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name="updated_at")
	private Date updatedAt;
}
