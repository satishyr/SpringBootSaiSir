package com.sai.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyBeanMethod1Condition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String value=System.getProperty("enableMyBeanMethod1");
		if(value == null) { 
			Environment env=context.getEnvironment();
			value = env.getProperty("enableMyBeanMethod1");
		}
		return Boolean.parseBoolean(value);
	}

}
