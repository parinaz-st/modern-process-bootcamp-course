package com.caribou.bank.web.rest;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OfficeResource {
    @Autowired
    OfficeService officeService;
    private final Logger logger = LoggerFactory.getLogger(OfficeResource.class);

    @PostMapping("/offices")
    public Office createOffice(@RequestBody Office office)
    {
        logger.debug("Rest Request to Save Office: {}", office);
        Office result = officeService.createOffice(office);
        return result;
    }
}
