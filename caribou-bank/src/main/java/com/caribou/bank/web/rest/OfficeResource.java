package com.caribou.bank.web.rest;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.OfficeService;
import com.caribou.bank.service.dto.OfficeDTO;
import com.caribou.bank.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class OfficeResource {
    @Autowired
    OfficeService officeService;
    @Value("${caribou.clinetApp.name}")
    private String applicationName;
    private static final String ENTITY_NAME = "office";

    private final Logger logger = LoggerFactory.getLogger(OfficeResource.class);

    /**
     * {@code Post /offices}: create a new office
     *
     * @param officeDto
     * @return {@link ResponseEntity} with status {@code 201(cerated) and with body he new officeDTO or with status{@code 400(bad request) if has already exists}}
     * @throws URISyntaxException if the location URI is incorrect
     */
    @PostMapping("/offices")
    public ResponseEntity<OfficeDTO> createOffice(@RequestBody OfficeDTO officeDto) throws URISyntaxException {
        logger.debug("Rest Request to Save Office: {}", officeDto);
        if (officeDto.getId() != null) {
            throw new BadRequestAlertException("A new office cannot already has an ID", ENTITY_NAME, "idexists");
        }
        OfficeDTO result = officeService.createOffice(officeDto);
//        return new ResponseEntity<>(result, HttpStatus.OK);
        return ResponseEntity.created(new URI("/api/offices/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);

    }

    /**
     * {@code PUT/offices}: Updates an existing office.
     * @param officeDTO the officeDto to update
     * @return {@link ResponseEntity} with status {@code 200}  and with body the updated Office DTO
     * or with status {@code 400(Bad Request)}
     * or with status{@code 500 (Internal Server Error)} if the officeDto couldn't be updated
     */

    @PutMapping("/offices")
    public ResponseEntity<OfficeDTO> updateOffice(@RequestBody OfficeDTO officeDTO)
    {
        logger.info("Rest Request to update office: {}", officeDTO);
        if(officeDTO.getId() == null)
            throw new BadRequestAlertException("invalid Id", ENTITY_NAME, "idnull");
        if(!officeService.existById(officeDTO.getId()))
            throw  new BadRequestAlertException("entity not found", ENTITY_NAME, "idnotfound");
        OfficeDTO result =  officeService.update(officeDTO);

//        return  ResponseEntity.ok(result);
        return  ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, officeDTO.getId().toString()))
                .body(result);

    }
}
