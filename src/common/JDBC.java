package common;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static final BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();
    static {
        BASIC_DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
        BASIC_DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/abol");
        BASIC_DATA_SOURCE.setMaxTotal(10);
        BASIC_DATA_SOURCE.setUsername("root");
        BASIC_DATA_SOURCE.setPassword("Am311865186");
    }
    public static Connection getConnection()throws Exception{
        Connection connection = BASIC_DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
