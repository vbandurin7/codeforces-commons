package com.codeforces.commons.properties.internal;

import com.codeforces.commons.properties.PropertiesUtil;

import java.util.List;

/**
 * @author Mike Mirzayanov
 */
public class CodeforcesCommonsPropertiesUtil {
    private CodeforcesCommonsPropertiesUtil() {
        throw new UnsupportedOperationException();
    }

    public static String getProperty(String propertyName, String defaultValue) {
        return PropertiesUtil.getPropertyQuietly(
                propertyName, defaultValue,
                "/com/codeforces/commons/properties/codeforces_commons.properties",
                "/com/codeforces/commons/properties/codeforces_commons_default.properties"
        );
    }

    public static List<String> getListProperty(String propertyName, String defaultValue) {
        return PropertiesUtil.getListProperty(
                propertyName, defaultValue,
                "/com/codeforces/commons/properties/codeforces_commons.properties",
                "/com/codeforces/commons/properties/codeforces_commons_default.properties"
        );
    }

    public static String getApplicationTempDirName() {
        return getProperty("temp-dir.name", "temp");
    }

    public static List<String> getSecurePasswords() {
        return ComplexPropertyValuesHolder.SECURE_PASSWORDS;
    }

    public static List<String> getSecureHosts() {
        return ComplexPropertyValuesHolder.SECURE_HOSTS;
    }

    public static String getSubscriptionToken() {
        return getProperty("security.subscription-token", "secret");
    }

    private static final class ComplexPropertyValuesHolder {
        private static final List<String> SECURE_PASSWORDS = getListProperty("security.secure-passwords", "");
        private static final List<String> SECURE_HOSTS = getListProperty("security.secure-hosts", "");

        private ComplexPropertyValuesHolder() {
            throw new UnsupportedOperationException();
        }
    }
}
