package com.wesell.authenticationserver.controller;

import com.wesell.authenticationserver.dto.request.AdminAuthRoleRequestDto;
import com.wesell.authenticationserver.service.AdminAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin-auth-server")
@RequiredArgsConstructor
public class AdminAuthController {
    private final AdminAuthService adminAuthService;

    @PutMapping("change-role/{uuid}")
    public ResponseEntity<String> changeUserRole(@PathVariable String uuid, @RequestBody AdminAuthRoleRequestDto adminAuthRoleRequestDto) {
        try {
            adminAuthService.updateRole(uuid, adminAuthRoleRequestDto.getRole());
            return new ResponseEntity<>("User role changed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to change user role: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

