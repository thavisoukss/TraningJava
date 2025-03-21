package com.bee.moveData;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillerDataMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        BillerData data = new BillerData();

        try {

            data.setBillType(rs.getString("BILL_TYPE"));
            data.setBillName(rs.getString("BILLER_NAME"));
            data.setProvinceId(rs.getString("PROVINCE_ID"));
            data.setBillNo(rs.getString("BILL_NO"));
            data.setUser(rs.getString("BILLERMOBILENO"));
        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
