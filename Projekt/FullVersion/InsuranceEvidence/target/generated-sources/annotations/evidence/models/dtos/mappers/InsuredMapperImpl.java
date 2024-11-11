package evidence.models.dtos.mappers;

import evidence.data.entities.InsuredEntity;
import evidence.models.dtos.InsuredDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T15:12:07+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class InsuredMapperImpl implements InsuredMapper {

    @Override
    public InsuredDTO toDTO(InsuredEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuredDTO insuredDTO = new InsuredDTO();

        insuredDTO.setId( source.getId() );
        insuredDTO.setName( source.getName() );
        insuredDTO.setEmail( source.getEmail() );
        insuredDTO.setStreet( source.getStreet() );
        insuredDTO.setSurname( source.getSurname() );
        insuredDTO.setPhone( source.getPhone() );
        insuredDTO.setCity( source.getCity() );
        insuredDTO.setPostCode( source.getPostCode() );

        return insuredDTO;
    }

    @Override
    public InsuredEntity toEntity(InsuredDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuredEntity insuredEntity = new InsuredEntity();

        insuredEntity.setId( source.getId() );
        insuredEntity.setName( source.getName() );
        insuredEntity.setEmail( source.getEmail() );
        insuredEntity.setStreet( source.getStreet() );
        insuredEntity.setSurname( source.getSurname() );
        insuredEntity.setPhone( source.getPhone() );
        insuredEntity.setCity( source.getCity() );
        insuredEntity.setPostCode( source.getPostCode() );

        return insuredEntity;
    }
}
