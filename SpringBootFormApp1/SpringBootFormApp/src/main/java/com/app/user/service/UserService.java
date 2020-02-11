package com.app.user.service;

import java.util.List;

import com.app.user.pojo.PageDto;
import com.app.user.pojo.User;
/**
 * This is Service Rules or method to perform some operation 
 * @author satish
 *
 */
public interface UserService {
		/**
		 * method used to save the data in Database 
		 * 
		 * @param user
		 * @return Integer
		 */
		public Integer saveUserEntity(User user);
		
		/**
		 *this method used to get all user data from database 
		 * @return List of Users object
		 */
		public List<User>  getAllUser();
		/**
		 * this Method is used to delete the record from database 
		 * it is  perform  hard deletion
		 * 
		 * @param userId
		 */
		public Integer deleteUserByid(Integer userId,Integer pageNum);
		/**
		 * This method is used to get One user data based on his primary key
		 * 
		 * @param userId
		 * @return User
		 */
		public User findUserById(Integer userId);
		/**
		 * this mehtod is used to updated the user data in database
		 * @param user
		 * @return User
		 */
		public User UpdateUser(User user);
		/**
		 * this method is used perform server side pagination 
		 * to get record based on page size
		 * 
		 * @param currPage
		 * @param pageSize
		 * @return PageDto
		 */
		public PageDto  serverSidepagination(Integer currPage,Integer pageSize);
		/**
		 * 
		 * this is deletion operation for RestApi
		 * @param userId
		 * @return Integer
		 */
		public Integer deleteuserFromRestApi(Integer userId);
		
		
		
		
}
