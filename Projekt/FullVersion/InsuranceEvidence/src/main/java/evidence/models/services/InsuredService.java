package evidence.models.services;

import evidence.models.dtos.InsuredDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InsuredService {

    Page<InsuredDTO> getAll(Pageable pageable);

    InsuredDTO getById(long id);

    void create(InsuredDTO insured);

    void edit(InsuredDTO insured);

    void remove(long id);
}
