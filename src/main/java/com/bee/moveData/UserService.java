package com.bee.moveData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    @Qualifier("primaryJdbcTemplate") // Injecting the primary database JdbcTemplate
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate") // Injecting the secondary database JdbcTemplate
    private JdbcTemplate secondaryJdbcTemplate;

    public List<UserTrustOut>  GetUser() {
        List<UserTrustOut> result = new ArrayList<>();
        String sql = "SELECT username, uid FROM trustuser.cust_user ";

        result =  primaryJdbcTemplate.query(sql , new UserTrustMapper());
        System.out.println(result);

        return result;
    }

    public List<BillerData> GetTelco(String mobile) {

        List<BillerData> result = new ArrayList<>();

        System.out.println("******************* start get Telco biller ****************");

        String sql = " SELECT  BILL_TYPE , BILLER_NAME , PROVINCE_ID , BILL_NO , BILLERMOBILENO  FROM EBANK.TELCO_VIEW ";
        System.out.println(sql);
        // String sql = " SELECT  BILL_TYPE , BILLER_NAME , PROVINCE_ID , BILL_NO , BILLERMOBILENO  FROM EBANK.TELCO_VIEW WHERE BILLERMOBILENO  = '"+mobile+"' ";
        result = secondaryJdbcTemplate.query(sql , new BillerDataMapper());

        //System.out.println(result);

        return result;

    }

    public List<BillerData> GetWater(String mobile) {

        List<BillerData> result = new ArrayList<>();

        String sql = " SELECT  BILL_TYPE , BILLER_NAME , PROVINCE_ID , BILL_NO , BILLERMOBILENO  FROM EBANK.WATER_VIEW WHERE BILLERMOBILENO  = '"+mobile+"' ";
        result = secondaryJdbcTemplate.query(sql , new BillerDataMapper());

        System.out.println(result);

        return result;

    }

    public List<BillerData> GetElec(String mobile) {

        List<BillerData> result = new ArrayList<>();

        String sql = " SELECT  BILL_TYPE , BILLER_NAME , PROVINCE_ID , BILL_NO , BILLERMOBILENO  FROM EBANK.ELEC_VIEW WHERE BILLERMOBILENO  = '"+mobile+"' ";
        result = secondaryJdbcTemplate.query(sql , new BillerDataMapper());

        System.out.println(result);

        return result;

    }

    public int MoveDatTelco(String billType, String billName, UUID custId, String proId, String BillNo) {

        String move = "MOVE_TELCO";

        int i = 0;
        try {

            String SQL = " insert into  biller_recent (bill_type , bill_name , customer_id  , province_id , bill_no , core_ref ) VALUES ('"+billType+"' , '"+billName+"' , '"+custId+"' , '"+proId+"' , '"+BillNo+"' , '"+move+"' ) " ;
            i = primaryJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }
        return i;
    }


    public int MoveDataWater(String billType, String billName, UUID custId, String proId, String BillNo) {

        String move = "MOVE_WATER";

        int i = 0;
        try {

            String SQL = " insert into  biller_recent (bill_type , bill_name , customer_id  , province_id , bill_no , core_ref ) VALUES ('"+billType+"' , '"+billName+"' , '"+custId+"' , '"+proId+"' , '"+BillNo+"' , '"+move+"' ) " ;
            i = primaryJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }
        return i;
    }

    public int MoveDataElec(String billType, String billName, UUID custId, String proId, String BillNo) {

        String move = "MOVE_ELEC";

        int i = 0;
        try {

            String SQL = " insert into  biller_recent (bill_type , bill_name , customer_id  , province_id , bill_no , core_ref ) VALUES ('"+billType+"' , '"+billName+"' , '"+custId+"' , '"+proId+"' , '"+BillNo+"' , '"+move+"' ) " ;
            i = primaryJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }
        return i;
    }



    public int StoreTelco(String billType, String billName,  String proId, String BillNo ,String  MobileNo) {


        int i = 0;
        try {

            String SQL = " insert into  biller_old (billtype , billname , proid  , billno , mobileno ) VALUES ('"+billType+"' , '"+billName+"' ,  '"+proId+"', '"+BillNo+"' , '"+MobileNo+"' ) " ;
            i = primaryJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }
        return i;
    }

}
