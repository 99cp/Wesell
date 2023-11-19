package com.wesell.dealservice.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    /**
     * create category
     */
    DUPLICATED_REQUEST(HttpStatus.BAD_REQUEST, "400", "이미 존재하는 카테고리입니다."),

    /**
     * create posting
     */
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "400", "유효하지 않은 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}