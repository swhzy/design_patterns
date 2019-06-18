package com.swh.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Object> queryList(String sql,RowMapper rowMapper) throws Exception {
        //1.获取连接
        //2.准备sql
        //3.执行sql，并获取结果集
        //4.解析结果集
        //5.关闭连接
        Connection connection = getConnection();

        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);

        ResultSet resultSet = getResultSet(preparedStatement);

        List<Object> list = handlerResult(rowMapper, resultSet);

        close(connection, preparedStatement);
        return list;
    }

    private void close(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    private List<Object> handlerResult(RowMapper rowMapper, ResultSet resultSet) throws SQLException {
        List<Object> list = new ArrayList<>();
        if(resultSet.next()){
           list.add(rowMapper.handlerResultInfo(resultSet));
        }
        return list;
    }

    private ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }

    private PreparedStatement getPreparedStatement(String sql, Connection connection) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
