package evidence.models.services;

import evidence.data.entities.InsuredEntity;
import evidence.data.repositories.InsuredRepository;
import evidence.models.dtos.InsuredDTO;
import evidence.models.dtos.mappers.InsuredMapper;
import evidence.models.exceptions.InsuredNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuredMapper insuredMapper;

    @Override
    public Page<InsuredDTO> getAll(Pageable pageable) {
        return insuredRepository.findAll(pageable)
                .map(insuredMapper::toDTO);
    }

    @Override
    public InsuredDTO getById(long id) {
        return insuredRepository.findById(id)
                .map(insuredMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void create(InsuredDTO insured) {
        InsuredEntity insuredEntity = insuredMapper.toEntity(insured);
        insuredRepository.save(insuredEntity);
    }

    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity existingEntity = getInsuredOrThrow(insured.getId());
        insuredMapper.updateEntity(insured, existingEntity);
        insuredRepository.save(existingEntity);
    }

    private InsuredEntity getInsuredOrThrow(long id) {
        return insuredRepository
                .findById(id)
                .orElseThrow(InsuredNotFoundException::new);
    }

    @Override
    public void remove(long id) {
        insuredRepository.deleteById(id);
    }
}
