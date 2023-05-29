package slowboat.slowboat.model.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import slowboat.slowboat.model.basic.JpaBaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Writer extends JpaBaseTimeEntity implements Persistable {
    @Id
    String username;

    String nickname;
    int boatCnt;

    int commentCnt;

    int allLikes;

    int allShares;

    String photo;

    String password;

    String type;

    public Writer(String username,String nickname, String password, String type){
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
    }




    @Override
    public Object getId() {
        return this.username;
    }

    @Override
    public boolean isNew() {
        return createdTime == null;
    }
}
