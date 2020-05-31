package com.webproject.icollect.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.webproject.icollect.pojo.UserDO;

import java.util.*;

public class TokenUtil {

    private static final String SECRET = "9a96349e2345385785e804e0f4254dee";
    private static String ISSUER = "sys_user";

    public static String getToken(UserDO user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // token 过期时间 4 小时
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.HOUR_OF_DAY, 4);

        JWTCreator.Builder builder = JWT.create().
                withIssuer(ISSUER). //发行人
                withExpiresAt(c.getTime()). //过期时间点
                withClaim("id",String.valueOf(user.getId())).
                withClaim("username", user.getUsername()).
                withClaim("role",String.valueOf(user.getRole()));
        return builder.sign(algorithm);
    }

    public static Map<String, String> verifyToken(String token) throws SignatureVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        DecodedJWT jwt =  verifier.verify(token);
        Map<String, Claim> map = jwt.getClaims();
        Map<String, String> resultMap = new HashMap<>();
        map.forEach((k,v) -> resultMap.put(k, v.asString()));
        return resultMap;
    }
}
