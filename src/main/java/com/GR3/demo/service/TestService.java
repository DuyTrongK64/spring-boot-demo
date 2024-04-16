package com.GR3.demo.service;

import com.microsoft.applicationinsights.TelemetryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Service
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    public void performAction() {
        TelemetryClient telemetryClient = new TelemetryClient();
        logger.info("Performing an action");
        try {

            telemetryClient.trackTrace("error");

            logger.error("new Error");
        } catch (Exception e) {
            logger.error("Error occurred while performing action", e);
        }
        finally {
            Date date = new Date();
            telemetryClient.trackHttpRequest("test", date,3000,"200",true);
        }
    }

}
