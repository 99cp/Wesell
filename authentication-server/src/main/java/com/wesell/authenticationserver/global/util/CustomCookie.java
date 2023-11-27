package com.wesell.authenticationserver.global.util;

import com.wesell.authenticationserver.response.CustomException;
import com.wesell.authenticationserver.response.ErrorCode;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Optional;

//JWT를 담을 쿠키 생성 및 기한 만료 기능 구현
@Component
public class CustomCookie {

    // 쿠키 생성
    public ResponseCookie createTokenCookie(String token){

        return ResponseCookie.from("access-token", token)
                .path("/")
                .httpOnly(true)
                .maxAge(60*60)
                .build();
    }

    // 로그인 시 이메일 저장 기능 쿠키 생성.
    public ResponseCookie createSavedEmailCookie(String email){

        return ResponseCookie.from("savedEmail",email)
                .path("/")
                .httpOnly(true)
                .maxAge(60 * 60 *24)
                .build();

    }

    // 쿠키 무효화
    public ResponseCookie deleteTokenCookie(){
        return ResponseCookie.from("access-token")
                .path("/")
                .httpOnly(true)
                .maxAge(0)
                .build();
    }

    public ResponseCookie deleteSavedEmailCookie(){
        return ResponseCookie.from("savedEmail")
                .path("/")
                .httpOnly(true)
                .maxAge(0)
                .build();
    }

    // 토큰 조회
    public Optional<Cookie> getJwt(Cookie[] cookies){

        return Arrays.stream(cookies)
                .filter(c -> "access-token".equals(c.getName())).findFirst();

    }

}
