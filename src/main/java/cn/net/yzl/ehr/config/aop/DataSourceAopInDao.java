package cn.net.yzl.ehr.config.aop;

import cn.net.yzl.ehr.config.mysql.DataSourceContextHolder;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在dao层决定数据源(注：如果用这方式，service层不能使用事务，否则出问题，因为打开事务打开时，就会觉得数据库源了）
 *
 */
//@Aspect
//@Component
public class DataSourceAopInDao {

	private static Logger log = LoggerFactory.getLogger(DataSourceAopInDao.class);
	
	@Before("execution(* cn.net.yzl.ehr.mapper..*.find*(..)) "
			+ " or execution(* cn.net.yzl.ehr.mapper..*.get*(..)) "
			+ " or execution(* cn.net.yzl.ehr.mapper..*.query*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setRead();
    }

    @Before("execution(* cn.net.yzl.ehr.mapper..*.insert*(..)) "
    		+ " or execution(* cn.net.yzl.ehr.mapper..*.update*(..))"
    		+ " or execution(* cn.net.yzl.ehr.mapper..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }
    
    
/*    @Before("execution(* com.fei.springboot.dao..*.*(..)) "
			+ " and @annotation(com.fei.springboot.annotation.ReadDataSource) ")
	public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
	    
	}
	
	@Before("execution(* com.fei.springboot.dao..*.*(..)) "
			+ " and @annotation(com.fei.springboot.annotation.WriteDataSource) ")
	public void setWriteDataSourceType() {
	    DataSourceContextHolder.setWrite();
	}*/
}
