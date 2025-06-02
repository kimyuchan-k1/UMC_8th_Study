package umc.spring.web.dto.mission;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class MissionResponseDto {
    private Long missionId;
    private Integer reward;
    private String missionSpec;


    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreMissionDTO {
        // 보상
        private Integer reward;
        // 미션 이름
        private String missionSpec;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreMissionListDTO {
        List<StoreMissionDTO> storeMissionDTOList;
        // list 길이
        Integer ListSize;
        // 총 페이지
        Integer totalPage;
        // 총 조회 목록 개수
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
