package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

public interface ReviewCommandService {
    ReviewResponseDto addReview(ReviewRequestDto request);
}
