package com.wesell.dealservice.domain.dto.response;

import com.wesell.dealservice.domain.entity.DealPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoResponseDto {

    private String title;
    private LocalDate createdAt;
    private Long price;
    private String detail;
    private String link;
    private String nickname;
    private String imageUrl;

    public PostInfoResponseDto (DealPost post, String nickname, String imageUrl) {
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.price = post.getPrice();
        this.detail = post.getDetail();
        this.link = post.getLink();
        this.nickname = nickname;
        this.imageUrl = imageUrl;
    }

}