package com.backend.app.controller;

import com.backend.app.model.NoteModel;
import com.backend.app.model.ReportModel;
import com.backend.app.producer.Sender;
import com.backend.app.service.ReportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/reports-section")
public class ReportsController {

    private ReportsService reportsService;
    private Sender sender;
    private static Logger logger = LogManager.getLogger();

    public ReportsController(Sender sender, ReportsService reportsService) {
        this.sender = sender;
        this.reportsService = reportsService;
    }

    @GetMapping(value = "/send")
    public String endpoint(@RequestParam("message") String message) {
        sender.send(message);
        return "Your message has been sent successfully";
    }

    @GetMapping(value = "/reports")
    public List<ReportModel> getReports() {
        logger.info("CONTROLLER LAYER - Getting reports...");
        return reportsService.getReports();
    }

    @PostMapping(value = "/note")
    public ReportModel createReport(@Valid ReportModel report) {
        logger.info("CONTROLLER LAYER - Creating report...");
        return reportsService.creteReport(report);
    }

    @PutMapping(value = "/note")
    public ReportModel updateNote(@Valid ReportModel report, String report_id) {
        logger.info("CONTROLLER LAYER - Updating report...");
        return reportsService.updateReport(report, report_id);
    }

    @DeleteMapping(value= "/note")
    public void deleteNote(@Valid String report_id){
        logger.info("CONTROLLER LAYER - Deleting report...");
        reportsService.deleteNote(report_id);
    }
}
