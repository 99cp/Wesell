package com.wesell.userservice.controller;

import com.wesell.userservice.dto.feigndto.AdminFeignResponseDto;
import com.wesell.userservice.dto.feigndto.SignUpResponseDto;
import com.wesell.userservice.dto.request.SignupRequestDto;
import com.wesell.userservice.dto.response.AdminUserResponseDto;
import com.wesell.userservice.error.exception.SuccessCode;
import com.wesell.userservice.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserFeignController {

    private final UserServiceImpl userService;

    // 관리자 - 회원 관리 - 회원 검색 + 페이징
    @GetMapping("search-users")
    public Page<AdminUserResponseDto> searchUsers(@RequestParam("name") String name,
                                                  @RequestParam("nickname") String nickname,
                                                  @RequestParam("phone") String phone,
                                                  @RequestParam("uuid") String uuid,
                                                  @RequestParam("page") int page,
                                                  @RequestParam("size") int size){
        return userService.searchUsers(name, nickname, phone, uuid, page, size);
    }

    // 관리자 - 회원 관리 - 회원 전체 목록 + 페이징
    @GetMapping("user-list")
    public Page<AdminFeignResponseDto> getUserList(@RequestParam("page") int page,
                                                   @RequestParam("size") int size){
        return userService.getUserList(page, size);
    }

    // 인증/인가 - SMS 인증 번호 - 회원 uuid 조회
    @PostMapping("users/phone/uuid")
    public String findID(@RequestBody String phoneNumber) {
        return userService.getUuidByPhone(phoneNumber);
    }

    // 인증/인가 - 회원 가입
    @PostMapping("sign-up")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignupRequestDto signupRequestDTO) {
        SignUpResponseDto signUpResponseDto = SignUpResponseDto.of(SuccessCode.USER_CREATED);
        userService.save(signupRequestDTO);
        return ResponseEntity.ok(signUpResponseDto);
    }

    // 인증/인가 - 회원 탈퇴
    @DeleteMapping("users/{uuid}")
    public ResponseEntity<Void> deleteUserEntity(@PathVariable String uuid) {
        userService.delete(uuid);
        return ResponseEntity.ok(null);

    }

    // 판매글 - 판매 상세 - 닉네임 조회
    @GetMapping("users/{uuid}/nickname")
    public ResponseEntity<String> getNicknameByUuid(@PathVariable String uuid) {
        String nickname = userService.getNicknameByUuid(uuid);
        return ResponseEntity.ok(nickname);
    }
}
