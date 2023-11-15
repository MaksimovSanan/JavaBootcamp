package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class HikariDS{
        private static final DataSource dataSource;
        private static final HikariConfig config = new HikariConfig();
        static {
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/chatserver");
            config.setUsername("postgres");
            config.addDataSourceProperty("password", "postgres");
            config.setMaximumPoolSize(10);
            config.setConnectionTimeout(50000);
            dataSource = new HikariDataSource(config);
        }
        public static DataSource getDataSource {
            return dataSource;
    }

}
