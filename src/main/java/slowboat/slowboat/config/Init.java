package slowboat.slowboat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;
import slowboat.slowboat.model.Entity.Writer;
import slowboat.slowboat.service.BoatService;
import slowboat.slowboat.service.WriterService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Init {

    private final BoatService boatService;
    private final WriterService writerService;

    @PostConstruct
    public void init(){


        Writer writer1 = new Writer("aaaa","릴리","1111","USER");
        Writer writer2 = new Writer("bbbb","오해원","2222","USER");
        Writer writer3 = new Writer("cccc","설윤","3333","USER");
        Writer writer4 = new Writer("dddd","배진솔","4444","USER");
        Writer writer5 = new Writer("eeee","지우","5555","USER");
        Writer writer6 = new Writer("ffff","장규진","6666","USER");

        writerService.saveWriter(writer1);
        writerService.saveWriter(writer2);
        writerService.saveWriter(writer3);
        writerService.saveWriter(writer4);
        writerService.saveWriter(writer5);
        writerService.saveWriter(writer6);


        boatService.save(new Boat("엔믹스", "릴리", Category.CREATION, writer1));
        boatService.save(new Boat("엔믹스", "오해원", Category.CREATION, writer2));
        boatService.save(new Boat("엔믹스", "설윤", Category.CREATION, writer3));
        boatService.save(new Boat("엔믹스", "배진솔", Category.CREATION, writer4));
        boatService.save(new Boat("엔믹스", "지우", Category.CREATION, writer5));
        boatService.save(new Boat("엔믹스", "장규진", Category.CREATION, writer6));
    }

}
