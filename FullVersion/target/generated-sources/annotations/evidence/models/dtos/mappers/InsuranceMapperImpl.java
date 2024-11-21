package evidence.models.dtos.mappers;

import evidence.data.entities.InsuranceEntity;
import evidence.data.entities.InsuredEntity;
import evidence.models.dtos.InsuranceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T23:42:22+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class InsuranceMapperImpl implements InsuranceMapper {

    @Override
    public InsuranceDTO toDTO(InsuranceEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuranceDTO insuranceDTO = new InsuranceDTO();

        insuranceDTO.setInsuredId( sourceInsuredId( source ) );
        insuranceDTO.setId( source.getId() );
        insuranceDTO.setInsuranceType( source.getInsuranceType() );
        insuranceDTO.setAmount( source.getAmount() );
        insuranceDTO.setInsuredSubject( source.getInsuredSubject() );
        insuranceDTO.setDateFrom( source.getDateFrom() );
        insuranceDTO.setDateTo( source.getDateTo() );

        return insuranceDTO;
    }

    @Override
    public InsuranceEntity toEntity(InsuranceDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuranceEntity insuranceEntity = new InsuranceEntity();

        insuranceEntity.setInsured( insuranceDTOToInsuredEntity( source ) );
        insuranceEntity.setId( source.getId() );
        insuranceEntity.setInsuranceType( source.getInsuranceType() );
        insuranceEntity.setAmount( source.getAmount() );
        insuranceEntity.setInsuredSubject( source.getInsuredSubject() );
        insuranceEntity.setDateFrom( source.getDateFrom() );
        insuranceEntity.setDateTo( source.getDateTo() );

        return insuranceEntity;
    }

    @Override
    public void updateEntity(InsuranceDTO source, InsuranceEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setInsuranceType( source.getInsuranceType() );
        target.setAmount( source.getAmount() );
        target.setInsuredSubject( source.getInsuredSubject() );
        target.setDateFrom( source.getDateFrom() );
        target.setDateTo( source.getDateTo() );
    }

    @Override
    public void updateDTO(InsuranceEntity source, InsuranceDTO target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setInsuranceType( source.getInsuranceType() );
        target.setAmount( source.getAmount() );
        target.setInsuredSubject( source.getInsuredSubject() );
        target.setDateFrom( source.getDateFrom() );
        target.setDateTo( source.getDateTo() );
    }

    private long sourceInsuredId(InsuranceEntity insuranceEntity) {
        if ( insuranceEntity == null ) {
            return 0L;
        }
        InsuredEntity insured = insuranceEntity.getInsured();
        if ( insured == null ) {
            return 0L;
        }
        long id = insured.getId();
        return id;
    }

    protected InsuredEntity insuranceDTOToInsuredEntity(InsuranceDTO insuranceDTO) {
        if ( insuranceDTO == null ) {
            return null;
        }

        InsuredEntity insuredEntity = new InsuredEntity();

        insuredEntity.setId( insuranceDTO.getInsuredId() );

        return insuredEntity;
    }
}
