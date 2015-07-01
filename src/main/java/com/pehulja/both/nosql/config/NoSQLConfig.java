package com.pehulja.both.nosql.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@ComponentScan("com.pehulja.both.nosql")
@EnableCouchbaseRepositories(basePackages = "com.pehulja.both.nosql.repositories")
@PropertySource("classpath:application.properties")
@Profile("nosql")
public class NoSQLConfig extends AbstractCouchbaseConfiguration {

	private static final String PROPERTY_COUCHBASE_LOCATION = "couchbase.host";
	private static final String PROPERTY_COUCHBASE_BACKET = "couchbase.backet";
	private static final String PROPERTY_COUCHBASE_PASSWORD = "couchbase.password";

	@Resource
	private Environment env;

	@Override
	protected List<String> bootstrapHosts() {
		return Arrays.asList(env.getProperty(PROPERTY_COUCHBASE_LOCATION));
	}

	@Override
	protected String getBucketName() {
		return env.getProperty(PROPERTY_COUCHBASE_BACKET);
	}

	@Override
	protected String getBucketPassword() {
		return env.getProperty(PROPERTY_COUCHBASE_PASSWORD);
	}
}
