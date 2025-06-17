package org.eppay.api.common.error;

import lombok.Getter;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.enums.SuccessCode;

@Getter
public class BaseException extends RuntimeException {

    String respCode;
    String respMessage;

    public BaseException(ErrorCode errorCode) {
        this.respCode = errorCode.getErrorCode();
        this.respMessage = errorCode.getErrorMsg();
    }

    public BaseException(SuccessCode errorCode) {
        this.respCode = errorCode.getCode();
        this.respMessage = errorCode.getValue();
    }

    @Override
    public String toString() {
        return "{" +
                "respCode:'" + respCode + '\'' +
                ", respMessage:'" + respMessage + '\'' +
                '}';
    }
}
