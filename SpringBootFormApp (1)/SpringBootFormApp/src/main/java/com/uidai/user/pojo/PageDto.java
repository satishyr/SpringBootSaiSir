package com.uidai.user.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class used as Data transfer object for getting more values as a method return type 
 * from service to controller 
 * 
 * @author Rituraj
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

	private List<User> list;
	private Integer currPage;
	private Integer totalPage;
}
