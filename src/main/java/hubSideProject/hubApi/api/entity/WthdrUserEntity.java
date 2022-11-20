package hubSideProject.hubApi.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="wthdrUser")
public class WthdrUserEntity {
	@OneToOne
	@JoinColumn(name="id")
	private UserEntity id;
	
    @CreatedDate
	@Column(name="wthdr_at")
	private Date wthdrAt;
}
