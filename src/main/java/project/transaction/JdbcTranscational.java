package project.transaction;

/**
 * @Auther d
 * @Date 2023/1/12 14:01
 * @Describe
 **/
import java.sql.*;

public class JdbcTranscational {

    /**
     * mysql连接url
     */
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    /**
     * 数据库连接账号名
     */
    private static final String USER = "root";
    /**
     * 数据库连接密码
     */
    private static final String PASSWORD = "root";
    /**
     * mysql数据库驱动类名
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * @return java.sql.Connection
     * @Author cuizx
     * @Description 获取数据库连接
     * @Date 2019/8/23 21:39
     * @Param []
     **/
    private Connection getConnection() {
        Connection conn = null;
        try {
            //加载mysql驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @return void
     * @Author cuizx
     * @Description 按照连接方式倒序关闭所有连接
     * @Date 2019/8/23 21:42
     * @Param [conn, stmt, resultSet]
     **/
    private void closeConnection(Connection conn, Statement stmt, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author cuizx
     * @Description 执行sql
     * @Date 2020/11/21
     * @Param [sql]
     * @return void
     **/
    public void executeSql(String sql) {
        Statement stmt = null;
        int result = 0;
        Connection connection = getConnection();
        try {
            //JDBC中默认是true，自动提交事务（这里手动成false）
            connection.setAutoCommit(false);
            //创建声明
            stmt = connection.createStatement();
            //执行sql
            result = stmt.executeUpdate(sql);
            System.out.println("执行结果：" + result);
            //提交事务
            connection.commit();
        } catch (Exception e) {
            try {
                //抛错后回滚
                connection.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            closeConnection(connection, stmt, null);
        }
    }

    public static void main(String[] args) {
        String sql = "select * from user";
        String insertSql = "insert into user (id,userName) values('123','cuizx')";
        String updateSql = "update user set userName ='更新后' where id ='123'";
        String deleteSql = "delete from user where id ='123'";

        JdbcTranscational jdbcTranscational = new JdbcTranscational();
        jdbcTranscational.executeSql(insertSql);
        jdbcTranscational.executeSql(updateSql);
        jdbcTranscational.executeSql(deleteSql);
    }
}