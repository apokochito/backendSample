package com.backend.app.controller;

import com.backend.app.domain.ReportDomain;
import com.backend.app.service.ReportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/reports-section")
public class ReportsController {

    private ReportsService reportsService;
    private static Logger logger = LogManager.getLogger();

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping(value = "/reports")
    @ResponseBody
    public ResponseEntity<Object> getReports() {
        logger.info("CONTROLLER LAYER - Getting reports...");
        return new ResponseEntity<>(reportsService.getReports(), HttpStatus.OK);
    }

    @PostMapping(value = "/report", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Object> createReport(@RequestBody @Valid ReportDomain report) {
        logger.info("CONTROLLER LAYER - Creating report...");
        return new ResponseEntity<>(reportsService.creteReport(report), HttpStatus.CREATED);
    }

    @PutMapping(value = "/report/{report_id}")
    @ResponseBody
    public ResponseEntity<Object> updateNote(@RequestBody @Valid ReportDomain report, @PathVariable String report_id) {
        logger.info("CONTROLLER LAYER - Updating report...");
        return new ResponseEntity<>(reportsService.updateReport(report, report_id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/report/{report_id}")
    public String deleteNote(@PathVariable String report_id) {
        logger.info("CONTROLLER LAYER - Deleting report...");
        reportsService.deleteNote(report_id);
        return "Report deleted.";
    }
}
