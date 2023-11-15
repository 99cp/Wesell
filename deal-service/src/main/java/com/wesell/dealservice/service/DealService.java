package com.wesell.dealservice.service;

import com.wesell.dealservice.domain.dto.request.CreateDealPostRequestDto;
import com.wesell.dealservice.domain.dto.request.EditPostRequestDto;
import com.wesell.dealservice.domain.dto.response.EditPostResponseDto;
import com.wesell.dealservice.domain.dto.response.PostInfoResponseDto;

public interface DealService {
    void createDealPost(CreateDealPostRequestDto requestCreatePostDto);
    EditPostResponseDto editPost(EditPostRequestDto requestDto, Long postId);
    void deletePost(Long postId);
    PostInfoResponseDto getPostInfo(Long postId);
}
