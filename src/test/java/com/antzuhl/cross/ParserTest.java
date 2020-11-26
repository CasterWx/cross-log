package com.antzuhl.cross;

import com.antzuhl.cross.model.ServiceLog;
import lombok.extern.slf4j.Slf4j;

/**
 * @author AntzUhl
 * @Date 2020/11/26 12:05
 * @Description
 */
@Slf4j
public class ParserTest {

    public static void main(String[] args) {
        String logStr = "[2020-11-26 11:36:53.743] [DEBUG] [xxl-job, executor ExecutorRegistryThread] com.xxl.job.core.thread.ExecutorRegistryThread 51 [TID: N/A] - >>>>>>>>>>> xxl-job registry success, registryParam:RegistryParam{registGroup='EXECUTOR', registryKey='sharks-tesseract-job-manageorder', registryValue='10.155.10.99:28005'}, registryResult:ReturnT [code=200, msg=null, content=null]";
        String split = "TID: N/A";
        String [] logs = logStr.split(split);
        log.info("logs: {}", logs);
        ServiceLog serviceLog = new ServiceLog();
        System.out.println(logs[1]);
        serviceLog.setLogInfo(logs[1]);
        String []ap = logs[0].split("] ");
        for (int i = 0; i < ap.length; i++) {
            System.out.println(ap[i]);
        }
    }
}
