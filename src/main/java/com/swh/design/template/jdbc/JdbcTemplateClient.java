package com.swh.design.template.jdbc;

import java.util.List;

public class JdbcTemplateClient {

    public static void main(String[] args) {
        String sql = "select * from t_user";
        List<Object> query = new UserDao().query(sql);

    }
}
