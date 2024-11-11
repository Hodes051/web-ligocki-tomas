package evidence.models.services;

import evidence.data.entities.InsuredEntity;
import evidence.data.repositories.InsuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;


    public Page<InsuredEntity> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return insuredRepository.findAll(pageable);
    }
}
