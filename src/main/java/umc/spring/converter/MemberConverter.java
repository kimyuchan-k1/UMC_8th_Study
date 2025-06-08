package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.LoginResultDTO;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    // Entity -> DTO 로 변환
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // DTO -> Entity 로 변환
    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1 :
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3 :
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(new Address(request.getAddress(),request.getSpecAddress()))
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .build();
    }



    public static LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }





}
