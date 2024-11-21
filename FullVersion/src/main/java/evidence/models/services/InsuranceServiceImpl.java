package evidence.models.services;

import evidence.data.entities.InsuranceEntity;
import evidence.data.entities.InsuredEntity;
import evidence.data.repositories.InsuranceRepository;
import evidence.data.repositories.InsuredRepository;
import evidence.models.dtos.InsuranceDTO;
import evidence.models.dtos.mappers.InsuranceMapper;
import evidence.models.exceptions.InsuranceNotFoundException;
import evidence.models.exceptions.InsuredNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public Page<InsuranceDTO> getByInsuredId(long insuredId, Pageable pageable) {
        return insuranceRepository.findByInsuredId(insuredId, pageable)
                .map(insuranceMapper::toDTO);
    }

    @Override
    public InsuranceDTO getById(long id) {
        return insuranceRepository.findById(id)
                .map(insuranceMapper::toDTO)
                .orElseThrow(InsuranceNotFoundException::new);
    }

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity insuranceEntity = insuranceMapper.toEntity(insurance);
        InsuredEntity insuredEntity = insuredRepository.findById(insurance.getInsuredId())
                .orElseThrow(InsuredNotFoundException::new);
        insuranceEntity.setInsured(insuredEntity);
        insuranceRepository.save(insuranceEntity);
    }

    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity existingEntity = getInsuranceOrThrow(insurance.getId());
        insuranceMapper.updateEntity(insurance, existingEntity);
        insuranceRepository.save(existingEntity);
    }

    private InsuranceEntity getInsuranceOrThrow(long id) {
        return insuranceRepository
                .findById(id)
                .orElseThrow(InsuranceNotFoundException::new);
    }

    @Override
    public void remove(long id) {
        insuranceRepository.deleteById(id);
    }
}
