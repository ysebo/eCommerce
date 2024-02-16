package com.example.eCommerce.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private String comment;
    private Integer rating;
}
