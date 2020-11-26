package com.antzuhl.cross.service.impl;

import com.antzuhl.cross.model.ServiceLog;
import com.antzuhl.cross.repository.ServiceLogRepository;
import com.antzuhl.cross.service.ServiceLogService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AntzUhl
 * @Date 2020/11/26 11:51
 * @Description
 */
public class ServiceLogServiceImpl implements ServiceLogService {

    @Autowired
    private ServiceLogRepository serviceLogRepository;

    @Override
    public long count() {
        return serviceLogRepository.count();
    }

    @Override
    public ServiceLog save(ServiceLog serviceLog) {
        return serviceLogRepository.save(serviceLog);
    }

    @Override
    public void delete(ServiceLog serviceLog) {
        serviceLogRepository.delete(serviceLog);
    }

    @Override
    public Iterable<ServiceLog> getAll() {
        return serviceLogRepository.findAll();
    }

    @Override
    public List<ServiceLog> getByApplication(String application) {
        List<ServiceLog> serviceLogs = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("application", application);
        Iterable<ServiceLog> iterable = serviceLogRepository.search(matchQueryBuilder);
        iterable.forEach(serviceLogs::add);
        return serviceLogs;
    }

    @Override
    public Page<ServiceLog> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("application", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return serviceLogRepository.search(searchQuery);
    }
}
