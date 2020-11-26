package com.antzuhl.cross.service;

import com.antzuhl.cross.model.ServiceLog;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author AntzUhl
 * @Date 2020/11/26 11:48
 * @Description
 */
public interface ServiceLogService {

    /**
     * 获取文档数量
     * */
    long count();

    /**
     * 保存一条
     * */
    ServiceLog save(ServiceLog serviceLog);

    /**
     * 删除一条，暂无使用场景
     * */
    void delete(ServiceLog serviceLog);

    /**
     * 获取所有文档
     * */
    Iterable<ServiceLog> getAll();

    /**
     * 根据应用查询日志
     * */
    List<ServiceLog> getByApplication(String application);

    /**
     * 分页查询
     * */
    Page<ServiceLog> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
