package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.LoginRequestDTO;
import umc.spring.web.dto.LoginResultDTO;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);


    LoginResultDTO loginMember(LoginRequestDTO request);
}
