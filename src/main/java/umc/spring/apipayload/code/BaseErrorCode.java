package umc.spring.apipayload.code;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();
    ErrorReasonDTO getReasonHttpStatus();
}
