package com.sai.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyBeanMethod2Condition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String value = System.getProperty("enableMyBeanMethod2");
		return Boolean.parseBoolean(value);
	}

}
