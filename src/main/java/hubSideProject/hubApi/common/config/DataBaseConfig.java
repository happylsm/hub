package hubSideProject.hubApi.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class DataBaseConfig {
	@Configuration
	@MapperScan(value = {"hubSideProject.hubApi.api.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
	public class MybatisConfig {

		@Bean(name="sqlSessionFactory")
		public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			sqlSessionFactoryBean.setTypeAliasesPackage("hubSideProject.hubApi.api.entity");
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*-mapper.xml"));
			return sqlSessionFactoryBean.getObject();
		}

	}
}
