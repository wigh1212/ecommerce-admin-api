package org.eppay.api.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eppay.api.common.error.BaseException;

import java.util.Arrays;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    //1000 벨리데이션 체크
    // 빈값_Error
    EMPTY_ID("1000","선택한 정보가 없습니다."),
    EMPTY_NAME("1001","이름을 입력하지 않았습니다."),
    EMPTY_PHONE("1002","전화번호를 입력하지 않았습니다."),
    EMPTY_EMAIL("1003","이메일을 입력하지 않았습니다."),
    EMPTY_BIRTHDAY("1004","생일을 입력하지 않았습니다."),
    EMPTY_COMPANY("1005","회사명을 입력하지 않았습니다."),
    EMPTY_BUSINESS_NUM("1006","사업자 등록번호를 입력하지 않았습니다."),
    EMPTY_SERIAL("1007", "시리얼 번호를 입력하지 않았습니다"),

    //2000 결과오류
    RESPONSE_FAIL_SEARCH("2002","조회를 실패했습니다."),
    RESPONSE_FAIL_INSERT("2003","등록을 실패했습니다."),
    RESPONSE_FAIL_UPDATE("2004","수정을 실패했습니다."),
    RESPONSE_FAIL_DELETE("2005","삭제를 실패했습니다."),
    RESPONSE_FAIL_DUPLICATION("2006","이미 등록된 정보입니다."),
    RESPONSE_FAIL_FOREIGN_KEY_DELETE("2005","참조 데이터가 있는 데이터는 삭제할 수 없습니다."),

    //3000 권한 오류
    // Spring Security 인증, 인가 권한
    AUTH_ENTRY_POINT("3000","인증정보가 유효하지 않습니다."),
    ACCESS_DENIED("3001","접근 권한이 부적합니다."),
    FORBIDDEN("3002","잘못된 접근입니다."),
    AUTH_INVALID_SIGNATURE("3003","시그니처 오류"),
    AUTH_INVALID_TOKEN("3004","유효하지 않은 JWT 토큰"),
    AUTH_TOKEN_EXPIRATION("3005","토큰 기한 만료"),
    AUTH_TOKEN_UNSUPPORTED("3006","지원되지 않는 JWT 형식"),
    AUTH_TOKEN_COMPACT("3007","JWT token compact of handler are invalid."),
    AUTH_ACCOUNT_SUSPENDED("3008","정지된 계정입니다. 관리자에게 문의하세요."),

    //4000 시스템오류
    COMMON_SYSTEM_ERROR("4000","일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("4001","요청한 값이 올바르지 않습니다."),
    COMMON_MOAPOS_SYSTEM_ERROR("4001","모아포스 시스템 오류 입니다."),
    COMMON_QR_SYSTEM_ERROR("4001","QR 시스템 오류 입니다."),

    EMPTY_BANK("5001","존재하지 않는 은행 id 입니다."), // 존재하지 않는 bank id

    EXIST_BUSINESS_NUMBER("5002","사업자번호가 중복입니다."),
    EXIST_MAPPING("5003","이미 존재하는 매칭정보입니다."),
    NOT_EXIST_CATEGORY("5004","존재하지 않는 카테고리 입니다."),
    NOT_EXIST_PRODUCT_OPTION("5004","존재하지 않는 상품 옵션 입니다."),
    NOT_EXIST_PRODUCT("5004","존재하지 않는 상품 입니다."),
    ;




    private String errorCode;
    private String errorMsg;

    public static String getMessage(String errorCode) {
        return Arrays.stream(ErrorCode.values())
                .filter(e -> e.getErrorCode().equals(errorCode))
                .map(ErrorCode::getErrorMsg)
                .findFirst().orElseGet(() -> String.valueOf(new BaseException(ErrorCode.COMMON_INVALID_PARAMETER)));
    }
}
