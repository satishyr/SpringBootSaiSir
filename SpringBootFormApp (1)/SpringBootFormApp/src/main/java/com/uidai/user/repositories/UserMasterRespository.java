package com.uidai.user.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uidai.user.entity.UserEntity;
/**
 * This is Repository which is extending property from Jpa Repository.
 * @author Rituraj
 */
@Repository
public interface UserMasterRespository extends JpaRepository<UserEntity, Serializable>{

	@Modifying
	@Transactional
	@Query("update UserEntity set active=0 where userId=:uid")
	public Integer softDeletion(Integer uid);
	
	@Query("select e from  UserEntity e where active=1")
	public Iterable<UserEntity> getAllActiveUser();
	
	@Query("select e from UserEntity e where active=1")
	public Page<UserEntity> getAllUserPaging(PageRequest pageRequest);
	
	@Query("select e from UserEntity e where e.userId=:uid and e.active=1")
	public Optional<UserEntity> getOneActiveUser(Integer uid);
	
	
}
