package umc.spring.converter;


import org.springframework.stereotype.Component;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionChallengeResponse;

@Component
public class MemberMissionConverter {
    public MissionChallengeResponse toResponse(MemberMission mm) {
        return new MissionChallengeResponse(
                mm.getId(), mm.getMission().getId(), mm.getStatus());
    }
}
