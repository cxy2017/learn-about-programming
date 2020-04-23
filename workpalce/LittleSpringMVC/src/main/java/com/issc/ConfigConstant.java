package com.issc;

/**
 * Config.properties配置文件
 */
public interface ConfigConstant {
    String UTF_8 = "UTF-8";
    String PROPERTIES_FILE="Config.properties";
    String DRIVER_CLASS_NAME="com.issc.jdbc.driver";
    String URL="com.issc.jdbc.url";
    String USER_NAME="com.issc.jdbc.username";
    String PASSWORD="com.issc.jdbc.password";

    String BASE_PACKAGE= "com.issc.app.base_package";
    String JSP_PATH="com.issc.app.jsp_path";
    String ASSET_PATH="com.issc.app.asset_path";
    String APP_UPLOAD_LIMIT="com.issc.app.upload_limit";
}
