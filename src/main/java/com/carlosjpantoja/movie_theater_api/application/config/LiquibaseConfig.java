package com.carlosjpantoja.movie_theater_api.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

	@Autowired
	public void configureInitialData(DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("/movie_theater_api.sql"));
		DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
	}

}
