package com.pehulja.both;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pehulja.both.dto.mocks.MocksGenerator;
import com.pehulja.both.service.CRUDService;

@SpringBootApplication
public class BothMySqlVsNoSqlApplication {

	@Autowired
	CRUDService crudService;
	
	@Autowired
	MocksGenerator mocksGenerator;
	
    public static void main(String[] args) {
        SpringApplication.run(BothMySqlVsNoSqlApplication.class, args);
    }

}
