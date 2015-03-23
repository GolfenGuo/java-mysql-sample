package io.daocloud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Storage {
  private final String dbName = System.getProperty("DB_NAME", "test"); 
  private final String userName = System.getProperty("DB_USERNAME", "root"); 
  private final String password = System.getProperty("DB_PASSWORD", ""); 
  private final String hostname = System.getProperty("DB_HOST", "mysql");
  private final int port = Integer.parseInt(System.getProperty("DB_PORT", "3306"));
  private final String databaseUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;

  private Connection conn;

  public Storage() throws Exception {
    Class.forName("com.mysql.jdbc.Driver").newInstance();

    conn = DriverManager.getConnection(databaseUrl, userName, password);

    try (Statement stmt = conn.createStatement()) {
      stmt.executeUpdate("DROP TABLE IF EXISTS scores");
      stmt.executeUpdate("CREATE TABLE scores(score INT)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void populate() {
    try (Statement stmt = conn.createStatement()) {
      stmt.executeUpdate("INSERT INTO scores(score) VALUES(1234)");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public Integer getScore() throws SQLException {
    try (Statement stmt = conn.createStatement()) {
      ResultSet rs = stmt.executeQuery("SELECT * FROM scores");
      rs.next();
      return rs.getInt("score");
    }
  }
}
