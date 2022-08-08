package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.dto.OfficeDTO;
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

    public OfficeDTO createOffice(OfficeDTO officeDto)
    {
        logger.debug("Request to Save Office Service: {}" , officeDto);
        //mapping DTO To Entity Class
        Office office = new Office();
        office.setName(officeDto.getName());
        office.setOpeningDate(officeDto.getOpeningDate());
        office.setExternalId(officeDto.getExternalID());
        office.setParent(fromId(officeDto.getParentID()));

        Office returnedOffice = officeRepository.save(office);
        //mapping Entity to DTO

        OfficeDTO officeDTO2 = new OfficeDTO();
        officeDTO2.setId(returnedOffice.getId());
        officeDTO2.setName(returnedOffice.getName());
        officeDTO2.setExternalID(returnedOffice.getExternalId());
        officeDTO2.setOpeningDate(returnedOffice.getOpeningDate());
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
