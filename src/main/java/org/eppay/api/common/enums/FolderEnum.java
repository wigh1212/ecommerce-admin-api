package org.eppay.api.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum FolderEnum {
    STORE_LOGO("1", "storeLogo"),
    STORE_EVENT("2", "storeEvent"),
    STORE_PRODUCT("3", "storeProduct");

    private String code;
    private String value;


   public static String get(String code) {
     for (FolderEnum folder : FolderEnum.values()) {
         if (folder.code.equals(code)) {
                 return folder.value;
         }
     }
     return null; // or throw an exception if preferred
  }
}
