package com.swh.design.template.jdbc;

import java.sql.ResultSet;

public interface RowMapper {

      Object handlerResultInfo(ResultSet resultSet);
}
