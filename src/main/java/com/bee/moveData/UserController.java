package com.bee.moveData;


import com.bee.moveData.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

     @Autowired
    UserService userService;

     @Autowired
    TokenService tokenService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Spring Boot REST API!";
    }


    @GetMapping("/user")
    public String user() {

           userService.GetUser();

        return "Welcome to the Spring Boot REST API!";
    }


    @PostMapping("/login")
    public String login(@RequestBody  User user) {

        return tokenService.login(user);
    }


//    @GetMapping("/user1")
//    public String user1() {
//
//       // userService.querySecondaryDatabase();
//
//        return "Welcome to the Spring Boot REST API!";
//    }
//
//    @GetMapping("/moveTelco")
//    public String moveTelco() {
//        List<UserTrustOut> result = new ArrayList<>();
//        List<BillerData> biller = new ArrayList<>();
//
//        result =  userService.GetUser();
//
//
//   if(result.size() > 0){
//
//       for(int i = 0 ; i < result.size() ; i++){
//           biller =  userService.GetTelco(result.get(i).getMobile());
//           System.out.println(" user : "+i);
//           if(biller.size() > 0 ){
//
//               for(int y = 0 ; y < biller.size() ; y++){
//                   userService.MoveDatTelco(biller.get(y).getBillType() , biller.get(y).getBillName(), UUID.fromString(result.get(i).getId()),biller.get(y).getProvinceId(),biller.get(y).getBillNo());
//                   System.out.println(" insert " + result.get(i).getMobile());
//               }
//           }
//       }
//   }
//
//        return " MOVE TELCO SUCCESS";
//    }
//
//    @GetMapping("/moveWater")
//    public String moveWater() {
//        List<UserTrustOut> result = new ArrayList<>();
//        List<BillerData> biller = new ArrayList<>();
//
//        result =  userService.GetUser();
//
//
//        if(result.size() > 0){
//            for(int i = 0 ; i < result.size() ; i++){
//                biller =  userService.GetWater(result.get(i).getMobile());
//                System.out.println(" user : "+i);
//                if(biller.size() > 0 ){
//
//                    for(int y = 0 ; y < biller.size() ; y++){
//                        userService.MoveDataWater(biller.get(y).getBillType() , biller.get(y).getBillName(), UUID.fromString(result.get(i).getId()),biller.get(y).getProvinceId(),biller.get(y).getBillNo());
//                        System.out.println(" insert " + result.get(i).getMobile());
//                    }
//                }
//            }
//        }
//
//        return " MOVE WATER SUCCESS !";
//    }
//
//    @GetMapping("/moveElect")
//    public String moveElect() {
//        List<UserTrustOut> result = new ArrayList<>();
//        List<BillerData> biller = new ArrayList<>();
//
//        result =  userService.GetUser();
//
//
//        if(result.size() > 0){
//
//            for(int i = 0 ; i < result.size() ; i++){
//                biller =  userService.GetElec(result.get(i).getMobile());
//                System.out.println(" user : "+i);
//                if(biller.size() > 0 ){
//
//                    for(int y = 0 ; y < biller.size() ; y++){
//                        userService.MoveDataElec(biller.get(y).getBillType() , biller.get(y).getBillName(), UUID.fromString(result.get(i).getId()),biller.get(y).getProvinceId(),biller.get(y).getBillNo());
//                        System.out.println(" insert " + result.get(i).getMobile());
//                    }
//                }
//            }
//        }
//
//        return " MOVE ELEC SUCCESS";
//    }
//
//    @GetMapping("/Telco")
//    public String Telco() {
//
//        List<BillerData> biller = new ArrayList<>();
//
//        biller = userService.GetTelco("");
//
//        if (biller.size() > 0) {
//
//            for (int i = 0; i < biller.size(); i++) {
//                System.out.println("user :"+i);
//                userService.StoreTelco(biller.get(i).getBillType(), biller.get(i).getBillName(), biller.get(i).getProvinceId(), biller.get(i).getBillNo(), biller.get(i).getUser());
//            }
//        }
//        return "move telco success";
//    }

}
