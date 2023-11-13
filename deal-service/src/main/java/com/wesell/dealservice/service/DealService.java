package com.wesell.dealservice.service;

import com.wesell.dealservice.domain.dto.request.CreateDealPostRequestDto;
import com.wesell.dealservice.domain.dto.request.EditPostRequestDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface DealService {
    void createDealPost(CreateDealPostRequestDto requestCreatePostDto);
    void editPost(EditPostRequestDto requestDto, @RequestParam Long postId);
}
