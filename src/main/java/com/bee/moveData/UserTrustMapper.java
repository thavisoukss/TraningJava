package com.bee.moveData;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTrustMapper  implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        UserTrustOut data =new UserTrustOut();

        try {

            data.setId(rs.getString("uid"));
            data.setMobile(rs.getString("username"));

        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
