package slowboat.slowboat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;
import slowboat.slowboat.model.Entity.Writer;
import slowboat.slowboat.service.BoatService;
import slowboat.slowboat.service.WriterService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

//@Component
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

        ArrayList<Writer> writers = new ArrayList<>();
        writers.add(writer1);
        writers.add(writer2);
        writers.add(writer3);
        writers.add(writer4);
        writers.add(writer5);

        for(int i = 0 ; i< 30; i++){
            int index = i% 5;
            boatService.save(new Boat("엔믹스"+i, "핑크플로이드"+i , Category.CREATION, writers.get(index)));
        }

    }

}
