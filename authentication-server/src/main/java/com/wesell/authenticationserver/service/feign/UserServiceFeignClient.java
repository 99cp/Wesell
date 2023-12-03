package com.wesell.authenticationserver.service.feign;

import com.wesell.authenticationserver.service.dto.response.CreateUserFeignResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="USER-SERVICE")
public interface UserServiceFeignClient {

    @PostMapping("api/sign-up")
    ResponseEntity<String> registerUserDetailInfo(@RequestBody CreateUserFeignResponseDto dto);

}
