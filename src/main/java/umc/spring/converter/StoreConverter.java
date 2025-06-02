package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.mission.MissionResponseDto;
import umc.spring.web.dto.store.StoreRequestDto;
import umc.spring.web.dto.store.StoreResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {


    public static Store toEntity(StoreRequestDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDto toResponseDto(Store store) {
        return new StoreResponseDto(
                store.getId(),
                store.getName(),
                store.getScore(),
                store.getRegion() != null ? store.getRegion().getName() : null
        );
    }

    public static StoreResponseDto.ReviewPreviewDTO toReviewPreviewDTO(Review review) {

        return StoreResponseDto.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDto.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {

        // 각 Review -> ReviewPreviewDTO로 변환한 후 List에 저장한다.
        List<StoreResponseDto.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::toReviewPreviewDTO).toList();

        return StoreResponseDto.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();


    }


    // O -> D
    public static MissionResponseDto.StoreMissionDTO toStoreMissionDTO (Mission mission) {
        return MissionResponseDto.StoreMissionDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .build();
    }


    public static MissionResponseDto.StoreMissionListDTO toStoreMissionListDTO (Page<Mission> missions) {

        // 각 Mission -> Mission Dto 로 바꾼다. ->
        List<MissionResponseDto.StoreMissionDTO> storeMissionList = missions.stream()
                .map(StoreConverter::toStoreMissionDTO)
                .toList();

        return MissionResponseDto.StoreMissionListDTO.builder()
                .storeMissionDTOList(storeMissionList)
                .ListSize(storeMissionList.size())
                .isLast(missions.isLast())
                .isFirst(missions.isFirst())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .build();


    }
}
