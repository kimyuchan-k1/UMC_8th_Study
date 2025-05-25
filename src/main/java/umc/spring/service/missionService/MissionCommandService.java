package umc.spring.service.missionService;

import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;

public interface MissionCommandService {
    MissionResponseDto addMission(MissionRequestDto request);
}
