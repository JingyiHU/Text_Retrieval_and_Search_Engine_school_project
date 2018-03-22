package main.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigManager {
	private static final Config conf = ConfigFactory.load();

	public static DbConfig getDbConfig() {
		DbConfig dbConfig = new DbConfig();
		dbConfig.setUsername(conf.getString("db.username"));
		dbConfig.setPassword(conf.getString("db.password"));
		dbConfig.setUrl(conf.getString("db.url"));
		
		System.out.println(dbConfig.toString());
		
		return dbConfig;
	}

}
