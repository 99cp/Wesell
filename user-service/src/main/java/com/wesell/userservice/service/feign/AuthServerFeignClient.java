package com.wesell.userservice.service.feign;

import com.wesell.userservice.dto.feigndto.AuthUserInfoRequestDto;
import com.wesell.userservice.dto.feigndto.EmailInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name="AUTHENTICATION-SERVER")
public interface AuthServerFeignClient {

    @GetMapping("api/v1/feign/auth-list")
    List<AuthUserInfoRequestDto> getListAuthUserInfo();

    @GetMapping("api/v1/emailinfo/{uuid}")
    ResponseEntity<EmailInfoDto> getEmailInfo(@PathVariable("uuid") String uuid);


}