package slowboat.slowboat.controller.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import slowboat.slowboat.model.Entity.Writer;
import slowboat.slowboat.model.basic.DefaultRes;
import slowboat.slowboat.service.WriterService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WriterController {

    private final WriterService writerService;

    @PostMapping("/writer")
    DefaultRes saveWriter(@RequestBody WriterRequestDto dto){
        Writer newWriter = new Writer(dto.getUsername(), dto.getNickname(), dto.getPassword(), dto.getType());
        String id = writerService.saveWriter(newWriter);
        return DefaultRes.res(20005, "writer를 생성했습니다.", id);
    }

    @Data
    @NoArgsConstructor
    public static class WriterRequestDto{
        String username;
        String nickname;
        String password;
        String type;

        public WriterRequestDto(String username, String nickname, String password, String type){
            this.username = username;
            this.nickname = nickname;
            this.password = password;
            this.type =type;
        }
    }


}
