/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/21
 */
package utils;

import com.ledgerserver.common.Constants;
import com.ledgerserver.entity.User;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.IllformedLocaleException;

public class TokenUtil {
    private static final String SECRET_KEY = "verysecurekey1234567890verysecurekey1234567890";
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder().setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            Date expirationDate = claimsJws.getBody().getExpiration();
            Date now = new Date();
            return !expirationDate.before(now);
        } catch (Exception e) {
            return false;
        }
    }

    public static String getUsernameFormToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
}
