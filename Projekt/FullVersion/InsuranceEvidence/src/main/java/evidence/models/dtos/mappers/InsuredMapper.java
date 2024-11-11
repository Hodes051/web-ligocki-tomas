package evidence.models.dtos.mappers;

import evidence.data.entities.InsuredEntity;
import evidence.models.dtos.InsuredDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuredMapper {

    InsuredDTO toDTO(InsuredEntity source);

    InsuredEntity toEntity(InsuredDTO source);
}
