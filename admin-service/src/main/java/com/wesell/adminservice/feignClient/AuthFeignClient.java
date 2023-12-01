package com.wesell.adminservice.feignClient;

import com.wesell.adminservice.dto.request.ChangeRoleRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="AUTHENTICATION-SERVER", path = "admin-auth-server")
public interface AuthFeignClient {

    @PutMapping("change-role")
    ResponseEntity<String> changeUserRole (@RequestBody ChangeRoleRequestDto changeRoleRequestDto);

    @PutMapping("updateIsForced/{uuid}")
    ResponseEntity<String> updateIsForced(@PathVariable String uuid);
}
