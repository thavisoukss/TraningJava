package com.bee.moveData.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bee.moveData.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {


    public String login (User req){

        return  tokenize(req);
    }

    public String tokenize(User req){

        String secert = "t#ddddd12GCW";


        Calendar calendar =  Calendar.getInstance();
        calendar.add(Calendar.MINUTE,60);
        Date expiresAt = calendar.getTime();

        return JWT.create()
                .withIssuer("backenService")
                .withClaim("principal",req.getUserId())
                .withClaim("rol","USER")
                .withExpiresAt(expiresAt)
                .sign(algorithm(secert));

    }

    public DecodedJWT verifyToken(String tokne){

        String secert = "t#ddddd12GCW";

        try {

            JWTVerifier verifier = JWT.require(algorithm(secert))
                    .withIssuer("backenService")
                    .build();
            DecodedJWT jwt = verifier.verify(tokne);
            return jwt;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    private Algorithm algorithm( String secert){
        return Algorithm.HMAC256(secert);
    }

}
