package com.caribou.bank.web.rest;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.OfficeService;
import com.caribou.bank.service.dto.OfficeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class OfficeResource {
    @Autowired
    OfficeService officeService;
    private final Logger logger = LoggerFactory.getLogger(OfficeResource.class);

    @PostMapping("/offices")
    public ResponseEntity <OfficeDTO> createOffice(@RequestBody OfficeDTO office) throws URISyntaxException {
        logger.debug("Rest Request to Save Office: {}", office);
        OfficeDTO result = officeService.createOffice(office);
        return new ResponseEntity<>(result, HttpStatus.OK);
        //        return ResponseEntity.created(new URI("/api/offices/" + officeDTO2.getId()))
//                .headers(HeaderUtil.createEntityCreationAlert(ApplicationName, true, ENTITY_NAME,
//                        officeDTO2.getId().toString()))
//                .body(officeDTO2);

    }
}
