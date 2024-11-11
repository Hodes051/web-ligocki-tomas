package evidence.models.dtos.mappers;

import evidence.data.entities.InsuredEntity;
import evidence.models.dtos.InsuredDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T17:32:29+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
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

    @Override
    public void updateEntity(InsuredDTO source, InsuredEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setEmail( source.getEmail() );
        target.setStreet( source.getStreet() );
        target.setSurname( source.getSurname() );
        target.setPhone( source.getPhone() );
        target.setCity( source.getCity() );
        target.setPostCode( source.getPostCode() );
    }

    @Override
    public void updateDTO(InsuredEntity source, InsuredDTO target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setEmail( source.getEmail() );
        target.setStreet( source.getStreet() );
        target.setSurname( source.getSurname() );
        target.setPhone( source.getPhone() );
        target.setCity( source.getCity() );
        target.setPostCode( source.getPostCode() );
    }
}
