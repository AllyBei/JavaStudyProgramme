package cn.hrs.allybei.JavaStudy.SpringBoot.utils;

import cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class DbUtils {

    private static SqlSessionFactory sqlSessionFactory = null;
    private static final Class CLASS_LOCK = DbUtils.class;


    /**
     * Use the only sql session factory to create sql session
     *
     * @return sql session from sql session factory
     */
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory==null){
            initSqlSessionFactory();
        }

        return sqlSessionFactory.openSession();
    }



    /**
     * Use Singleton mode, only create one sqlSessionFactory
     *
     * @return sqlSessionFactory
     */
    private static SqlSessionFactory initSqlSessionFactory() {
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                //Configure Data Source
                PooledDataSource dataSource = new PooledDataSource();
                dataSource.setDriver("org.mariadb.jdbc.Driver");
                dataSource.setUrl("jdbc:mariadb://localhost:22222/mybatis_test");
                dataSource.setUsername("root");
                dataSource.setPassword("Hrs12345");

                //Create transaction factory
                TransactionFactory transactionFactory = new JdbcTransactionFactory();

                //Configure mybatis environment with id,transaction factory and data source
                Environment env = new Environment("test", transactionFactory, dataSource);

                //Load environment configuration to mybatis
                Configuration configuration = new Configuration(env);

                //Load Mapper settings
                configuration.addMapper(UserMapper.class);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            }

            return sqlSessionFactory;
        }
    }


}
