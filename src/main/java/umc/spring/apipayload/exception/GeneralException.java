package umc.spring.apipayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
