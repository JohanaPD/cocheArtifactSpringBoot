package com.project_coche.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.project_coche.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.auth0.jwt.JWT;

import javax.naming.AuthenticationException;


@Component
public class JwAuthenticationProvider {
    @Value("${jwt.secret.key}")
    private String secretKey;

    private HashMap<String, CustomerDto> listToken= new HashMap<>();

    public Object createToken(CustomerDto customerJwt) {
        System.out.println("Secret Key: " + secretKey);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 360000);//Hora en milisegundos
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String tokenCreated = JWT.create()
                .withClaim("cardId", customerJwt.getCardId())
                .withClaim("fullname", customerJwt.getFirstName())
                .withClaim("numberCellPhone", String.valueOf(customerJwt.getNumberPhone()))
                .withClaim("email", customerJwt.getEmail())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, customerJwt);
        return tokenCreated;
    }

    public Authentication validateToken(String token)throws AuthenticationException {
        System.out.println("Secret Key validateToken: " + secretKey);
        System.out.println("Secret token: " + token);

        try {
            JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        } catch (com.auth0.jwt.exceptions.SignatureVerificationException e) {
            throw new BadCredentialsException("Invalid JWT signature", e);
        }

        CustomerDto customerJwt = listToken.get(token);

        if(customerJwt == null){
            throw new BadCredentialsException("Invalid token");
        }
        //Esto es solo para ver lo que carga, podemos excluirlo, tenemos la info del usuario
        UserDetails userTest= User.withUsername(customerJwt.getFirstName()).password(customerJwt.getPassword()).roles(customerJwt.getRol()).build();
        userTest.getAuthorities().forEach(System.out::println);

        HashSet<SimpleGrantedAuthority> rolesAndAutho = new HashSet<>();
        rolesAndAutho.add(new SimpleGrantedAuthority("ROLE_"+ customerJwt.getRol()));
        rolesAndAutho.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE"));

        return new UsernamePasswordAuthenticationToken(customerJwt, token, rolesAndAutho);
    }

    public String deleteToken(String token) {

        if(!listToken.containsKey(token)){
            return "Token not found";
        }
        listToken.remove(token);
        return "Sesión cerrada con éxito";
    }
}
