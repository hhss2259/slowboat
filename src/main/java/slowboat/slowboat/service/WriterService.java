package slowboat.slowboat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import slowboat.slowboat.model.Entity.Writer;
import slowboat.slowboat.repository.WriterRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class WriterService {

    private final WriterRepository writerRepository;

    @Transactional
    public String saveWriter(Writer writer) {
        Writer save = writerRepository.save(writer);
        return save.getUsername();
    }



}
