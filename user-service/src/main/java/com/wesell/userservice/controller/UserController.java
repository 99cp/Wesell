package com.wesell.userservice.controller;

import com.wesell.userservice.dto.request.SignupRequestDto;
import com.wesell.userservice.dto.response.ResponseDto;
import com.wesell.userservice.error.exception.UserNotFoundException;
import com.wesell.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("user")
    public ResponseEntity<ResponseDto> findUserResponseEntity(@RequestParam("uuid") String uuid) {
            return ResponseEntity.ok(userService.findUser(uuid));

    }

    @GetMapping("users")
    public ResponseEntity<List<ResponseDto>> findUsersResponseEntity() {
            return ResponseEntity.ok(userService.findUsers());

    }

    @DeleteMapping("user/{uuid}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable String uuid) {
            userService.deleteUser(uuid);
            return ResponseEntity.ok("성공적으로 삭제되었습니다.");

    }

    @PostMapping("/api/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto signupRequestDTO) {
            userService.save(signupRequestDTO);
            return new ResponseEntity<>("Signup successful", HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> updateUser(@PathVariable String uuid, @RequestBody SignupRequestDto signupRequestDTO) {
            userService.updateUser(uuid, signupRequestDTO);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);

    }

    @GetMapping("/users/{uuid}/nickname")
    public ResponseEntity<String> getNicknameByUuid(@PathVariable String uuid) {
        String nickname = userService.getNicknameByUuid(uuid);
        return ResponseEntity.ok(nickname);
    }
}
