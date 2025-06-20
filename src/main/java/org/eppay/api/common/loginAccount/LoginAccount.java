package org.eppay.api.common.loginAccount;

import lombok.Data;

@Data
public class LoginAccount {
    private String username;
    private String displayName;
    private String name;
    private String type;
    private Long storeId;
}
