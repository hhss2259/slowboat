package slowboat.slowboat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import slowboat.slowboat.error.LastBoatException;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;
import slowboat.slowboat.repository.BoatRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BoatService {

    private final BoatRepository boatRepository;

    @Transactional
    public int save(Boat boat){
        Boat savedBoat = boatRepository.save(boat);
        return savedBoat.getId();
    }


    public Boat getBoatRandomly(){
        Boat boatRandomly = boatRepository.getBoatRandomly();
        return boatRandomly;
    }


    public Page<Boat> getBoatByCategory(Category category, Pageable pageable) {

        Page<Boat> boats;
        if(category == Category.ALL){
            boats = boatRepository.getBoatAll(pageable);
        }else{
            boats = boatRepository.getBoatByCategory(category, pageable);
        }
        return boats;
    }

    public Boat getBoatOrderly(int id) {
        if(id == 0){
            id = boatRepository.findMaxBoatId()+1;
        }
        if(id == 1){
            throw new LastBoatException();
        }
        Boat boatOrderly = boatRepository.getBoatOrderly(id);
        return boatOrderly;
    }
}
