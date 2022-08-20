package com.caribou.bank.mapper;

import com.caribou.bank.domain.Office;
import com.caribou.bank.service.dto.OfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * com.caribou.bank.mapper for entity {@link Office} and its DTO {@link OfficeDTO}
 */
@Mapper(componentModel = "spring", uses={})
public interface OfficeMapper {

    @Mapping(source = "parentID", target = "parent")
    Office toEntity(OfficeDTO officeDTO);
    @Mapping(source = "parent.id", target="parentID")
    OfficeDTO toOfficeDTO(Office office);

    default Office fromId(Long id)
    {
        if(id == null)
            return null;
        Office office = new Office();
        office.setId(id);
        return office;
    }

}
