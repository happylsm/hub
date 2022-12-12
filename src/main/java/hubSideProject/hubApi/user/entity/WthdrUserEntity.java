package hubSideProject.hubApi.user.entity;

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

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@DynamicUpdate
@ToString
@Table(schema="user", name="withdrawal_user")
public class WthdrUserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @CreatedDate
	@Column(name="wthdr_at")
	private Date wthdrAt;
}
