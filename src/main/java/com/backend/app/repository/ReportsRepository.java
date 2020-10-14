package com.backend.app.repository;

import com.backend.app.model.ReportModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends MongoRepository<ReportModel, String> {
}
