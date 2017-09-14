package com.ylx.librarymanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ylx.librarymanage.dao")
@SpringBootApplication
public class LibrarymanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanageApplication.class, args);
	}
}
