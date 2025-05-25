package umc.spring.converter;


import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;

public class MissionConverter {

    public static Mission toEntity(MissionRequestDto dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDto toResponseDto(Mission mission) {
        return new MissionResponseDto(
                mission.getId(),
                mission.getReward(),
                mission.getMissionSpec()
        );
    }
}
