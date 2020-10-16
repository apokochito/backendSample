package com.backend.app.service;

import com.backend.app.domain.ReportDomain;
import com.backend.app.model.ReportModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportsService {

    List<ReportDomain> getReports();

    ReportDomain creteReport(ReportDomain report);

    ReportDomain updateReport(ReportDomain report, String report_id);

    void deleteNote(String report_id);

}
