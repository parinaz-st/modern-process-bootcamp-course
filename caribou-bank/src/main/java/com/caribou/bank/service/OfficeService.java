package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.backoff.BackOffExecution;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    private Logger logger = LoggerFactory.getLogger(OfficeService.class);

    public Office createOffice(Office office)
    {
        logger.debug("Request to Save Office Service: {}" , office);
        return officeRepository.save(office);
    }

}
