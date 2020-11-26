package com.antzuhl.cross.repository;

import com.antzuhl.cross.model.ServiceLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceLogRepository extends ElasticsearchRepository<ServiceLog, String> {

}
