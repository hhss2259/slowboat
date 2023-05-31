package slowboat.slowboat.model.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoatByCategoryResponseDto {

    Category category;
    String content;
    int id;

   @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy년 MM월 dd일", timezone="Asia/Seoul")
    LocalDateTime createdTime;
    int likes;
    String title;
    String nickname;


    public void makeResponse(Boat boat){
        this.category = boat.getCategory();
        this.content = boat.getContent();
        this.id = boat.getId();
        this.createdTime = boat.getCreatedTime();
        this.likes = boat.getLikes();;
        this.title = boat.getTitle();
        this.nickname = boat.getWriter().getNickname();
    }

}
