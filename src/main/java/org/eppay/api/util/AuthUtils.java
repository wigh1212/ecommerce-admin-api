package org.eppay.api.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.eppay.api.domain.admin.model.AdminEntity;

public class AuthUtils {

    public static UserDetails getCurrentUserDetail() {
        try {
            return  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    public static AdminEntity getCurrentUser() {
        UserDetails userDetails = getCurrentUserDetail();

        if (userDetails != null) {
            if (userDetails instanceof AdminEntity) {
                return (AdminEntity) userDetails;
            }
        }

        return null;
    }

    public static boolean isLoggedIn() {
        return getCurrentUser() != null;
    }

    public static String getCurrentLoginUserCd() {
        UserDetails userDetails = getCurrentUserDetail();
        return userDetails == null ? "system" : userDetails.getUsername();
    }
}
