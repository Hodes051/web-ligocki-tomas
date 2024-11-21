package evidence.models.dtos.mappers;

import evidence.data.entities.InsuranceEntity;
import evidence.models.dtos.InsuranceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    @Mapping(source = "insured.id", target = "insuredId")
    InsuranceDTO toDTO(InsuranceEntity source);

    @Mapping(source = "insuredId", target = "insured.id")
    InsuranceEntity toEntity(InsuranceDTO source);

    void updateEntity(InsuranceDTO source, @MappingTarget InsuranceEntity target);

    void updateDTO(InsuranceEntity source, @MappingTarget InsuranceDTO target);
}
