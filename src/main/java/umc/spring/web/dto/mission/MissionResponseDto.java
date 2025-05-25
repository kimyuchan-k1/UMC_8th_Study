package umc.spring.web.dto.mission;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionResponseDto {
    private Long missionId;
    private Integer reward;
    private String missionSpec;
}
