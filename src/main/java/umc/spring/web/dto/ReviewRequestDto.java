package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.StoreExists;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewRequestDto {
    @StoreExists
    private Long storeId;
    private String title;
    private String body;
    private Float score;
}
