package slowboat.slowboat.controller.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;
import slowboat.slowboat.model.basic.DefaultRes;
import slowboat.slowboat.service.BoatService;

@RestController
@RequiredArgsConstructor
public class BoatController {

    private final BoatService boatService;


    @GetMapping("/boat")
    DefaultRes getBoatByRandom(){
        Boat boatRandomly = boatService.getBoatRandomly();
        return DefaultRes.res(20001, "랜덤 boat", boatRandomly);
    }


    @PostMapping("/boat")
    DefaultRes saveBoat(@RequestBody BoatSaveDto dto){
        System.out.println("dto.getTitle() = " + dto.getTitle());
        System.out.println("dto.getContent() = " + dto.getContent());
        System.out.println("dto.getCategory() = " + dto.getCategory());

        int id = boatService.save(new Boat(dto.getTitle(),dto.getContent(), dto.getCategory()));
        return DefaultRes.res(20000, "Boat를 저장했습니다", id);
    }

    @GetMapping("/boat/category")
    DefaultRes getBoatByCategory(@RequestParam("category") Category category, @PageableDefault(size = 20, page = 0) Pageable pageable){

        Page<Boat> boatByCategory = boatService.getBoatByCategory(category, pageable);

        return DefaultRes.res(20004,"boat list", boatByCategory);

    }

    @Data
    @NoArgsConstructor
    public static class BoatSaveDto{

        String title;
        String content;
        Category category;

        public BoatSaveDto(String title, String content, Category category){
            this.title = title;
            this.content =content;
            this.category = category;
        }

    }


}
