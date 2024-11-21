package evidence.models.services;

import evidence.models.dtos.InsuranceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InsuranceService {

    Page<InsuranceDTO> getByInsuredId(long insuredId, Pageable pageable);

    InsuranceDTO getById(long id);

    void create(InsuranceDTO insurance);

    void edit(InsuranceDTO insurance);

    void remove(long id);
}
