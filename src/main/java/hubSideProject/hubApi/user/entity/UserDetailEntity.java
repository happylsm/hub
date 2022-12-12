package hubSideProject.hubApi.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@DynamicUpdate
@ToString
@Table(schema="user", name="user_detail")
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
}
