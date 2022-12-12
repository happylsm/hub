package hubSideProject.hubApi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hubSideProject.hubApi.user.entity.UserDetailEntity;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>{

	boolean existsByNickName(String nickName);

}
