package cn.tacomall.tacomallspringbootutils;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import cn.tacomall.tacomallspringbootutils.DateUtil;
import cn.tacomall.tacomallspringbootcommon.exception.ServerException;

public class JwtUtil {
    private static final String SECRET = "cn.tacomall.secret";
    private static final String ISSUER = "user";

    public static String create(Map<String, String> claims) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTCreator.Builder builder = JWT.create()
                    .withIssuer(ISSUER)
                    .withExpiresAt(DateUtil.addHours(new Date(), 2));
            claims.forEach(builder::withClaim);
            return builder.sign(algorithm);
        } catch (IllegalArgumentException | JWTCreationException e) {
            throw new ServerException("生成token失败");
        }
    }

    public static Map<String, String> verify(String token) throws Exception {
        Algorithm algorithm;
        Map<String, Claim> map;
        try {
            algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            DecodedJWT jwt = verifier.verify(token);
            map = jwt.getClaims();
        } catch (JWTVerificationException e) {
            throw new ServerException("鉴权失败");
        }
        Map<String, String> resultMap = new HashMap<>(map.size());
        map.forEach((k, v) -> resultMap.put(k, v.asString()));
        return resultMap;
    }
}
