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
@Primary
@Configuration
public class DataSourceConfiguration1 {

	private static Logger log = LoggerFactory.getLogger(DataSourceConfiguration1.class);
	
	@Value("${mysql.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
    
	/**
	 * 写库 数据源配置
	 * @return
	 */
	@Bean(name = "writeDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource() {
        log.info("-------------------- writeDataSource init ---------------------");
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.type(dataSourceType);
        builder.url("jdbc:mysql://10.128.7.59:3306/yzl_staff?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        builder.username("readehr");
        builder.password("readehr!");
        builder.driverClassName("com.mysql.jdbc.Driver");
        return builder.type(dataSourceType).build();
    }
	
	/**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource")
//    @ConfigurationProperties(prefix = "mysql.datasource.read")
    public DataSource readDataSourceOne() {
        log.info("-------------------- read DataSourceOne init ---------------------");
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.type(dataSourceType);
        builder.url("jdbc:mysql://10.128.7.59:3306/yzl_staff?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        builder.username("readehr");
        builder.password("readehr!");
        builder.driverClassName("com.mysql.jdbc.Driver");
        return builder.type(dataSourceType).build();
    }


    
    
}
