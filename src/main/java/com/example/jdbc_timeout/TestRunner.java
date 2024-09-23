package com.example.jdbc_timeout;

import com.example.jdbc_timeout.mapper.EmpolyeesMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Slf4j
@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    EmpolyeesMapper empolyeesMapper;

    @Autowired
    TxComponent txComponent;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        1. login Timeout or connection Timeout
        接続失敗、ログイン失敗までのタイムアウト
        デフォルト値 = 0 (SimpleDriverDataSource)
        デフォルト値 = 30 (Hikari Pooling)
        Hikari Pooling を使う場合、applications.propertiesで設定できる。それ以外は設定できない。
        spring.datasource.hikari.connection-timeout=9000
         */
        log.info("loginTimeout: {}", dataSource.getLoginTimeout());

        /*
        2. Query Timeout
        クエリ(SQL)の実行タイムアウト
        デフォルトは
        JDBCTemplateの場合、-1(無制限)
        MyBatisの場合は、null(無制限?)
        設定方法
        JDBCTemplate: spring.jdbc.template.query-timeout
        MyBatis: mybatis.configuration.default-statement-timeout
         */
        SqlSession session = sqlSessionFactory.openSession();
        log.info("jdbcTemplate#queryTimeout 1: {}", jdbcTemplate.getQueryTimeout());
        log.info("mybatis statemetn timeout: {}", session.getConfiguration().getDefaultStatementTimeout());

        /*
        3. Network Timeout
        デフォルトは 0(未指定？)
        spring.database.urlに?socketTimeout=60を付ける
         */
        log.info("network timeout: {}", session.getConnection().getNetworkTimeout());

        /*
        4. Transaction Timeout
        デフォルトは -1 (無制限)
        設定方法不明
         */
        ((JdbcTransactionManager)transactionManager).setDefaultTimeout(60);
        log.info("TxManager defaultTimeout: {}", ((JdbcTransactionManager)transactionManager).getDefaultTimeout());


//        empolyeesMapper.sleep();
        txComponent.sleep();

        /*
        タイムアウトで発生する例外(Postgres)
        1. login timeout
        -> 再現できず

        2. query timeout
        -> Caused by: org.postgresql.util.PSQLException: ERROR: canceling statement due to user request

        trace ログ
        2024-09-23T22:09:18.553+09:00 TRACE 1789827 --- [jdbc-timeout] [C-SharedTimer-1] org.postgresql.core.QueryExecutorBase    :  FE=> CancelRequest(pid=5,109,ckey=-1,126,273,565)

        3. network timeout
        -> Caused by: java.net.SocketTimeoutException: Read timed out

        trace ログ
        2024-09-23T22:13:58.413+09:00 TRACE 1792061 --- [jdbc-timeout] [           main] org.postgresql.core.QueryExecutorBase    :  FE=> close socket

        4. transaction timeout
        -> Caused by: org.postgresql.util.PSQLException: ERROR: canceling statement due to user request

        trace ログ
        2024-09-23T22:19:53.823+09:00 TRACE 1795026 --- [jdbc-timeout] [C-SharedTimer-1] org.postgresql.core.QueryExecutorBase    :  FE=> CancelRequest(pid=5,168,ckey=319,676,983)



         */


    }
}
