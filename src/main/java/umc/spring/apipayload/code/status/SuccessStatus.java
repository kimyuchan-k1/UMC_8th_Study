package umc.spring.apipayload.code.status;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apipayload.code.BaseCode;
import umc.spring.apipayload.code.ReasonDTO;

import java.security.cert.CertPathValidatorException;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    //응답
    _OK(HttpStatus.OK, "COMMON200","성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSucess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSucess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
