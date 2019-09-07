package com.wyz.actviti.config;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {

	@Autowired
	private DataSource dataSource;

	/**
	 * 初始化配置，将创建25张表
	 *
	 * @return
	 */
	@Bean
	public StandaloneProcessEngineConfiguration processEngineConfiguration() {

		StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();

		configuration.setDataSource(dataSource);

		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		configuration.setAsyncExecutorActivate(false);

		return configuration;
	}

	/**
	 * 创建引擎
	 * 
	 * @return ProcessEngine
	 */
	@Bean
	public ProcessEngine processEngine() {
		return processEngineConfiguration().buildProcessEngine();
	}

}
