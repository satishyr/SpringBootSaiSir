package com.app.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.user.entity.UserEntity;
import com.app.user.pojo.PageDto;
import com.app.user.pojo.User;
import com.app.user.repositories.UserMasterRespository;
import com.app.user.service.UserService;
/**
 * This class is implementation of service rules and provide the implementation 
 * and follow the rules and guidelines
 * 
 * @author satish
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * To inject repository object for performing database operaions
	 */
	@Autowired
	private UserMasterRespository userMasterRespository;
	/**
	 * method used to save the data in Database here we get user object from controller 
	 * we need to convert user Object to UserEntity object
	 * 
	 * @param user
	 * @return Integer
	 */
	@Override
	public Integer saveUserEntity(User user) {
		user.setActive(1);
		UserEntity userEntity=new  UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		UserEntity entity = userMasterRespository.save(userEntity);
		if(entity.getUserId()!=null) {
			return entity.getUserId();
		}
		return null;
	}
	/**
	 *this method used to get all user data from database.
	 *here we need to convert one by one all object from list in userEntity to user object and
	 *Store again all user object in list 
	 *
	 * @return List of Users object
	 */
	@Override
	public List<User> getAllUser() {
		Iterable<UserEntity> userEntities = userMasterRespository.getAllActiveUser();
		List<User> usersList=new ArrayList<>();
		userEntities.forEach(userEntity->{
			User user=new User();
			BeanUtils.copyProperties(userEntity, user);
			usersList.add(user);
		});
		return usersList ;
	}

	/**
	 * this Method is used to delete the record from database 
	 * it is  perform  hard deletion
	 * 
	 * @param userId
	 */
	@Override
	public Integer deleteUserByid(Integer userId,Integer pageNum) {
		userMasterRespository.softDeletion(userId);
		PageRequest pageRequest=PageRequest.of(pageNum-1, 4);
		Page<UserEntity> pageEntity = userMasterRespository.getAllUserPaging(pageRequest);
		return pageEntity.getNumberOfElements();
	}
	/**
	 * This method is used to get One user data based on his primary key.
	 * and Covert userentity to user object 
	 * 
	 * @param userId
	 * @return User
	 */
	@Override
	public User findUserById(Integer userId) {
		User user=new User();
		Optional<UserEntity> userEntity = userMasterRespository.getOneActiveUser(userId);
		if(userEntity.isPresent()) {
			UserEntity userEntity2 = userEntity.get();
			BeanUtils.copyProperties(userEntity2, user);
			return user;
		}
		return null;
	}

	/**
	 * this mehtod is used to updated the user data in database
	 * @param user
	 * @return User
	 */
	@Override
	public User UpdateUser(User user) {
		user.setActive(1);
		UserEntity userEntity=new  UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity entity = userMasterRespository.save(userEntity);
		User user2=new User();
		BeanUtils.copyProperties(entity,user2);
		return user2;
	}


	/**
	 * this method is used perform server side pagination 
	 * to get record based on page size and convert UserEntity to user Object
	 * 
	 * @param currPage
	 * @param pageSize
	 * @return PageDto
	 */
	@Override
	public PageDto serverSidepagination(Integer currPage,Integer pageSize) {

		PageRequest pageRequest=PageRequest.of(currPage-1, pageSize);
		Page<UserEntity> pageEntity = userMasterRespository.getAllUserPaging(pageRequest);
		List<UserEntity> userEntities = pageEntity.getContent(); 
		int totalPageSize=pageEntity.getTotalPages();
		List<User> usersList=new ArrayList<>();
		userEntities.forEach(userEntity->{
			if(userEntity.getActive()!=0) {
			User user=new User();
			BeanUtils.copyProperties(userEntity, user);
			usersList.add(user);
			}
		});
		PageDto dto=new PageDto(usersList, currPage, totalPageSize);	
		return   dto;
	}
	/**
	 * this is used to perform deletion
	 * @param Integer
	 * return Integer
	 */
	@Override
	public Integer deleteuserFromRestApi(Integer userId) {
			Integer del = userMasterRespository.softDeletion(userId);
		return del;
	}
}
