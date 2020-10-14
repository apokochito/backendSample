package com.backend.app.service.impl;

import com.backend.app.model.NoteModel;
import com.backend.app.model.ReportModel;
import com.backend.app.repository.ReportsRepository;
import com.backend.app.service.ReportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportsServiceImpl implements ReportsService {

    private ReportsRepository reportsRepository;
    private static Logger logger = LogManager.getLogger();

    public ReportsServiceImpl(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    @Override
    public List<ReportModel> getReports() {
        logger.info("SERVICE LAYER - Getting reports...");
        return reportsRepository.findAll();
    }

    @Override
    public ReportModel creteReport(ReportModel report) {
        logger.info("SERVICE LAYER - Creating reports...");
        return reportsRepository.save(report);
    }

    @Override
    public ReportModel updateReport(ReportModel report, String report_id) {
        logger.info("SERVICE LAYER - Updating reports...");
        ReportModel report_from_database = reportsRepository.findById(report_id).orElseThrow(RuntimeException::new);
        report_from_database.setDate(report.getDate());
        report_from_database.setDescription(report.getDescription());
        return reportsRepository.save(report);
    }

    @Override
    public void deleteNote(String report_id) {
        logger.info("SERVICE LAYER - Deleting reports...");
        reportsRepository.deleteById(report_id);
    }
}
