package com.antzuhl.cross.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author AntzUhl
 * @Date 2020/11/26 11:38
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "service_log")
public class ServiceLog implements Serializable {

    @Id
    private String id;

    /**
     * 应用名
     * */
    private String application;

    /**
     * 日志时间
     * */
    private Date logTime;

    /**
     * 日志级别
     * */
    private String logLevel;

    /**
     * 日志线程
     * */
    private String logThread;

    /**
     * 处理类
     * */
    private String logClass;

    /**
     * 处理方法
     * */
    private String logMethod;

    /**
     * 日志发生行号
     * */
    private String logLine;

    /**
     * TID
     * */
    private String tid;

    /**
     * 日志内容
     * */
    private String logInfo;

    @Version
    private Long version;

}
