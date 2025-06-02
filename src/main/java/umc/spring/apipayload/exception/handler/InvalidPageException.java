package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.GeneralException;

public class InvalidPageException extends GeneralException {

    public InvalidPageException() {
        super(ErrorStatus.INVALID_PAGE_EXCEPTION);
    }

}
