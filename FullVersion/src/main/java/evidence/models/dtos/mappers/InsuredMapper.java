package evidence.models.dtos.mappers;

import evidence.data.entities.InsuredEntity;
import evidence.models.dtos.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuredMapper {

    InsuredDTO toDTO(InsuredEntity source);

    InsuredEntity toEntity(InsuredDTO source);

    void updateEntity(InsuredDTO source, @MappingTarget InsuredEntity target);

    void updateDTO(InsuredEntity source, @MappingTarget InsuredDTO target);
}
