package com.wesell.adminservice.controller;

import com.wesell.adminservice.domain.dto.RequestAdminDto;
import com.wesell.adminservice.domain.dto.ResponseAdminDto;
import com.wesell.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("set-config")
    public ResponseEntity<ResponseAdminDto> saveSiteConfig(@RequestBody RequestAdminDto requestAdminDto) {
        ResponseAdminDto savedSiteConfig = adminService.saveSiteConfig(requestAdminDto);
        return new ResponseEntity<>(savedSiteConfig, HttpStatus.CREATED);
    }

    @GetMapping("get-config")
    public ResponseEntity<ResponseAdminDto> getSiteConfig() {
        ResponseAdminDto currentSiteConfig = adminService.getSiteConfig();
        return new ResponseEntity<>(currentSiteConfig, HttpStatus.OK);
    }
}
