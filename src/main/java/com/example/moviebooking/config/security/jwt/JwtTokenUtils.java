package com.example.moviebooking.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtils {

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";


    private String secretKey = "amaaajkvkvkghchgxcjxoooondkgndlgn,dngldngldngldng";

    private Integer expirationInMinute = 24*60;

    public SecretKey getKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String getUsernameFromToken(String token){
        String username = getClaimsFromToken(token).getSubject();
        return username;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(String token){
        List<Map<String,String>> authorities = (List<Map<String, String>>) getClaimsFromToken(token).get("authorities");
        Set<SimpleGrantedAuthority> authoritySet =
                authorities.stream().map(m->new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toSet());

        return authoritySet;
    }

    public Date getIssuedAtDateFromToken(String token){
        Date createAt =  getClaimsFromToken(token).getIssuedAt();
        return createAt;
    }

    public Date getExpirationDateFromToken(String token){
        Date expirationDate = getClaimsFromToken(token).getExpiration();
        return expirationDate;
    }

    public Claims getClaimsFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(getKey())
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public boolean isExpireToken(String token){
        if (new DateTime().toDate().getTime() - getExpirationDateFromToken(token).getTime() < 0 ){
            return true;
        }
        return false;
    }


    public String getToken(String token){
        return token.replace("Bearer ","");
    }

    public Date generateExpirationDate(){
        return new DateTime().plusMinutes(expirationInMinute).toDate();
    }
    public String generateAudience(Device device){

//        if(device.isNormal()){
//            return AUDIENCE_WEB;
//        }
//        else if(device.isMobile()){
//            return AUDIENCE_MOBILE;
//        }
//        else if(device.isTablet()){
//            return AUDIENCE_TABLET;
//        }
//        else {
            return AUDIENCE_UNKNOWN;
       // }
    }
    public String generatedToken(String username, Collection<? extends GrantedAuthority> authorities, Device device){
        String token =  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new DateTime().toDate())
                .setExpiration(generateExpirationDate())
                .setAudience(generateAudience(device))
                .claim("authorities",authorities)
                .signWith(getKey())
                .compact();

        return "Bearer "+token;
    }
}
