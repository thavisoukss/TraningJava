package com.bee.moveData;

import com.bee.moveData.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class Business {

    @Autowired
    TokenService tokenService;
    public String Login(User req){

        String tokn ;
        tokn = tokenService.tokenize(req);
        return tokn;
    }


}
