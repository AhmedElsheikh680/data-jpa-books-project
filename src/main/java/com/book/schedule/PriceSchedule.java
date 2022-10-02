package com.book.schedule;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PriceSchedule {

    Logger logger = LoggerFactory.getLogger(PriceSchedule.class);

    @Scheduled( fixedRate = 2000)
//    @Scheduled(initialDelay = 2000,fixedRate = 2000)
//    @Scheduled(initialDelay = 2000,fixedRateString = "${price.schedule}")
//    @Scheduled(cron = "${interval-in-cron}")
    @SchedulerLock(name = "bookPriceCompute")
    @Async
    public void computePrice() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("Compute Price >> " + LocalDateTime.now());
    }

    @Scheduled( fixedRate = 2000)
    @SchedulerLock(name = "bookDiscountCompute")
    @Async
    public void computeDiscount() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("Compute Price >> " + LocalDateTime.now());
    }

}
