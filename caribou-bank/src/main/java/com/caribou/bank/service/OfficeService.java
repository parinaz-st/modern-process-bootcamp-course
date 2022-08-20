package com.caribou.bank.service;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.dto.OfficeDTO;
import com.caribou.bank.mapper.OfficeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;


@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    OfficeMapper officeMapper;
//    private final OfficeMapper officeMapper;
    @Value("${caribou.clinetApp.name}")
    private String applicationName;
    private static final  String ENTITY_NAME = "office";

    private Logger logger = LoggerFactory.getLogger(OfficeService.class);

//    public OfficeService( OfficeRepository officeRepository,OfficeMapper officeMapper) {
//        this.officeRepository = officeRepository;
//        this.officeMapper = officeMapper;
//    }

    public OfficeDTO createOffice(OfficeDTO officeDto) throws URISyntaxException {
        logger.debug("Request to Save Office Service: {}" , officeDto);
        Office office = officeMapper.toEntity(officeDto);
        Office returnedOffice = officeRepository.save(office);
//        //mapping DTO To Entity Class
//        Office office = new Office();
//        office.setName(officeDto.getName());
//        office.setOpeningDate(officeDto.getOpeningDate());
//        office.setExternalId(officeDto.getExternalID());
//        office.setParent(fromId(officeDto.getParentID()));
//
//        Office returnedOffice = officeRepository.save(office);
        //mapping Entity to DTO

        OfficeDTO officeDTO2 = officeMapper.toOfficeDTO(returnedOffice);
//        officeDTO2.setId(returnedOffice.getId());
//        officeDTO2.setName(returnedOffice.getName());
//        officeDTO2.setExternalID(returnedOffice.getExternalId());
//        officeDTO2.setOpeningDate(returnedOffice.getOpeningDate());
        return officeDTO2;
    }

    public Office fromId(Long id)
    {
        if(id == null)
            return null;
        Office office = new Office();
        office.setId(id);
        return office;
    }

}
