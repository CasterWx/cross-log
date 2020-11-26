package com.antzuhl.cross.handler.parser;

import com.antzuhl.cross.model.ServiceLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * @author AntzUhl
 * @Date 2020/11/26 11:58
 * @Description 服务日志解析
 */
@Slf4j
public class ServiceLogParser extends BaseParser{

    private static final String SPLIT_TID_STRING = "TID: N/A";

    private static final String SPLIT_APP_LEFT_STRING = "[";
    private static final String SPLIT_APP_RIGHT_STRING = "] ";

    @Override
    ServiceLog parser(String logStr) {
        if (StringUtils.isBlank(logStr)) {
            log.warn("[0]ServiceLogParser.parser bad parser log {}", logStr);
            return null;
        }
        // *尝试* 解析
        try {
            String[] logShard = logStr.split(SPLIT_TID_STRING);
            if (logShard.length != 2) {
                // 切分失败，非正常日志
                log.warn("[1]ServiceLogParser.parser split log is error, {}", logStr);
                return null;
            }
            String logApp = logShard[0];
            String []logApps = logApp.split(SPLIT_APP_RIGHT_STRING);
            if (logApps.length != 4) {
                // 切分失败，非正常日志
                log.warn("[2]ServiceLogParser.parser split logApps is error, {}", logStr);
                return null;
            }
            ServiceLog serviceLog = new ServiceLog();
            String logInfo = logShard[1];
            serviceLog.setLogInfo(logInfo.substring(1));
            serviceLog.setLogTime(new Date(logApps[0].replace(SPLIT_APP_LEFT_STRING, "")));
            serviceLog.setLogLevel(logApps[1].replace(SPLIT_APP_LEFT_STRING, ""));
            serviceLog.setLogThread(logApps[2].replace(SPLIT_APP_LEFT_STRING, ""));
            // 设置服务信息
            String logService = logApps[3];
            String []serviceMethod = logService.split(" ");
            if (serviceMethod.length != 3) {
                // 切分失败，非正常日志
                log.warn("[3]ServiceLogParser.parser split serviceMethod is error, {}", logStr);
                return null;
            }
            serviceLog.setLogClass(serviceMethod[0]);
            serviceLog.setLogLine(serviceMethod[1]);
            return serviceLog;
        } catch (Exception e) {
            log.error("[4]ServiceLogParser.parser Exception, {}, {}", logStr, e);
        }
        return null;
    }
}
