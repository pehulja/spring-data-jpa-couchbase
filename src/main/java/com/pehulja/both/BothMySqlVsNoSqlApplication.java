package com.pehulja.both;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BothMySqlVsNoSqlApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("jpa");
		ctx.scan("com.pehulja.both");
		ctx.refresh();
	}

}
