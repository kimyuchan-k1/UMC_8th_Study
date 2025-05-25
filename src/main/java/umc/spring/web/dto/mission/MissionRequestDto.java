package umc.spring.web.dto.mission;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissionRequestDto {
    private Long storeId;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}