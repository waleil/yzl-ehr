package cn.net.yzl.ehr.config.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据库源配置
 *
 */
@Configuration
public class DataSourceConfiguration {

	private static Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Value("${mysql.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
    
	/**
	 * 写库 数据源配置
	 * @return
	 */
	@Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource() {
        log.info("-------------------- writeDataSource init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
	
	/**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "mysql.datasource.read")
    public DataSource readDataSourceOne() {
        log.info("-------------------- read DataSourceOne init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    
    
}
