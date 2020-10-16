package com.backend.app.service.impl;

import com.backend.app.domain.ReportDomain;
import com.backend.app.model.ReportModel;
import com.backend.app.repository.ReportsRepository;
import com.backend.app.service.ReportsService;
import ma.glasnost.orika.MapperFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportsServiceImpl implements ReportsService {

    private ReportsRepository reportsRepository;
    private static Logger logger = LogManager.getLogger();
    private MapperFacade mapperFacade;

    public ReportsServiceImpl(ReportsRepository reportsRepository, MapperFacade mapperFacade) {
        this.reportsRepository = reportsRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<ReportDomain> getReports() {
        logger.info("SERVICE LAYER - Getting reports...");
        List<ReportDomain> reportsDomain = new ArrayList<>();
        List<ReportModel> reportsModel = reportsRepository.findAll();
        for (ReportModel reportModel : reportsModel) {
            ReportDomain reportDomain = new ReportDomain();
            mapperFacade.map(reportModel, reportDomain);
            reportsDomain.add(reportDomain);
        }
        return reportsDomain;
    }

    @Override
    public ReportDomain creteReport(ReportDomain reportDomain) {
        logger.info("SERVICE LAYER - Creating reports...");
        ReportModel reportModel = new ReportModel();
        mapperFacade.map(reportDomain, reportModel);
        reportsRepository.save(reportModel);
        ReportDomain reportDomainSaved = new ReportDomain();
        mapperFacade.map(reportModel, reportDomainSaved);
        return reportDomainSaved;
    }

    @Override
    public ReportDomain updateReport(ReportDomain reportDomain, String report_id) {
        logger.info("SERVICE LAYER - Updating reports...");
        reportDomain.set_id(report_id);
        ReportModel reportModel = reportsRepository.findById(report_id).orElseThrow(RuntimeException::new);
        mapperFacade.map(reportDomain, reportModel);
        reportsRepository.save(reportModel);
        return reportDomain;
    }

    @Override
    public void deleteNote(String report_id) {
        logger.info("SERVICE LAYER - Deleting reports...");
        reportsRepository.deleteById(report_id);
    }
}
