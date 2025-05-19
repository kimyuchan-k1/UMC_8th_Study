package umc.spring.apipayload.code;


import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDTO {
    private HttpStatus httpStatus;

    private final boolean isSucess;
    private final String code;
    private final String message;

    public boolean getIsSuccess() {
        return isSucess;
    }
}
