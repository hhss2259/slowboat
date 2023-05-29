package slowboat.slowboat.model.Entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slowboat.slowboat.model.basic.JpaBaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Boat extends JpaBaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "boat_id")
    int id;

    String title;

    @Column(length = 1000)
    String content;

    int views;

    @JoinColumn(name="writer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Writer writer;

    int likes;

    int shares;

    @Enumerated(EnumType.STRING)
    Category category;

    public Boat(String title, String content, Category category){
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Boat(String title, String content, Category category,Writer writer){
        this.title = title;
        this.content = content;
        this.category = category;
        this.writer = writer;
    }

}
