package com.sai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.sai.conditions.MyBeanMethod1Condition;
import com.sai.conditions.MyBeanMethod2Condition;

@Configuration
public class MyConfiguration {

	@Bean
	@Conditional(value=MyBeanMethod1Condition.class)
	public void myBeanMethod1() {
		System.out.println("In myBeanMethod1()........!");
	}
	
	@Bean
	@Conditional(value=MyBeanMethod2Condition.class)
	public void myBeanMethod2() {
		System.out.println("In myBeanMethod2().........!");
	}
	
}
