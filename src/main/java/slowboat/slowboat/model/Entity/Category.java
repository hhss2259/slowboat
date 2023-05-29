package slowboat.slowboat.model.Entity;

import lombok.Getter;

@Getter
public enum Category {
    LITERATURE("문학",1),
    PHILOSOPHY("철학",2),
    SELF("자기 계발",3),
    CREATION("창작",4),
    Lyrics("가사",5),
    LONG("장문",6);

    private String info;
    private int number;
    Category(String info, int number){
        this.info = info;
        this.number = number;
    }


}
