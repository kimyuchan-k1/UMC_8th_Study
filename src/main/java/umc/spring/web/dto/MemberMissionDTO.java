package umc.spring.web.dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionDTO {
    private MissionStatus status;
    private Long missionId;
}
