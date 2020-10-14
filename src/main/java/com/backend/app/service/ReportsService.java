package com.backend.app.service;

import com.backend.app.model.ReportModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportsService {

    List<ReportModel> getReports();

    ReportModel creteReport(ReportModel report);

    ReportModel updateReport(ReportModel report, String report_id);

    void deleteNote(String report_id);

}
