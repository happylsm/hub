package hubSideProject.hubApi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hubSideProject.hubApi.api.entity.UserDetailEntity;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>{

	boolean existsByNickName(String nickName);

}
