package com.yan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.yan.dao")
public class Last0020Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Last0020Application.class, args);
	}

	// 用于配置tomcat识别JavaConfig配置
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Last0020Application.class);
	}

	// 用于配置上下文参数
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("appName", "SpringBoot-ssm用户管理");
	}

}
