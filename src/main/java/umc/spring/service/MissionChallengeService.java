package umc.spring.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

@Service
@RequiredArgsConstructor
public class MissionChallengeService {

    private final MemberRepository memberRepo;
    private final MissionRepository missionRepo;
    private final MemberMissionRepository memberMissionRepo;
    private final MemberMissionConverter converter;

    @Transactional
    public MissionChallengeResponse challenge(MissionChallengeRequest dto) {

        Member member  = memberRepo.findById(dto.memberId())
                .orElseThrow(() -> new EntityNotFoundException("Member"));
        Mission mission = missionRepo.findById(dto.missionId())
                .orElseThrow(() -> new EntityNotFoundException("Mission"));

        MemberMission mm = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        memberMissionRepo.save(mm);
        return converter.toResponse(mm);
    }
}
