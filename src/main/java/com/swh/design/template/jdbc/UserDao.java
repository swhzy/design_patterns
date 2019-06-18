package com.swh.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao  {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<Object> query(String sql){
        try {
            return jdbcTemplate.queryList(sql, new RowMapper() {
                @Override
                public Object handlerResultInfo(ResultSet resultSet) {
                    User user = new User();
                    try {
                        user.setUserId(resultSet.getString("userId"));
                        user.setAddress(resultSet.getString("address"));
                        user.setAge(resultSet.getInt("age"));
                        user.setUserName(resultSet.getString("userName"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return user;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
