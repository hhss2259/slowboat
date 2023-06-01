package slowboat.slowboat.controller.api;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import slowboat.slowboat.model.basic.BoatByCategoryResponseDto;
import slowboat.slowboat.model.basic.DefaultPage;
import slowboat.slowboat.model.basic.DefaultRes;
import slowboat.slowboat.service.BoatService;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoatController {

    private final BoatService boatService;


    @GetMapping("/boat/random")
    DefaultRes getBoatByRandom(){
        Boat boatRandomly = boatService.getBoatRandomly();
        BoatResponseDto responseDto = new BoatResponseDto(boatRandomly.getId(), boatRandomly.getWriter().getNickname(), boatRandomly.getCreatedTime(), boatRandomly.getLikes(), boatRandomly.getContent(), boatRandomly.getTitle());
        return DefaultRes.res(20001, "랜덤 boat", responseDto);
    }

    @GetMapping("/boat/order")
    DefaultRes getBoatByRandom(@RequestParam int id){
        Boat boatRandomly = boatService.getBoatOrderly(id);
        BoatResponseDto responseDto = new BoatResponseDto(boatRandomly.getId(), boatRandomly.getWriter().getNickname(), boatRandomly.getCreatedTime(), boatRandomly.getLikes(), boatRandomly.getContent(), boatRandomly.getTitle());
        return DefaultRes.res(20001, "순서 boat", responseDto);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoatResponseDto {
        int id;
        String nickname;
        @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy년 MM월 dd일", timezone="Asia/Seoul")
        LocalDateTime createdTime;
        int likes;
        String content;
        String title;
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
    DefaultPage getBoatByCategory(@RequestParam("category") Category category, @PageableDefault(size = 5, page = 0) Pageable pageable){

        Page<Boat> boatByCategory = boatService.getBoatByCategory(category, pageable);
        return DefaultPage.res(20004, "boat category list", boatByCategory);

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
