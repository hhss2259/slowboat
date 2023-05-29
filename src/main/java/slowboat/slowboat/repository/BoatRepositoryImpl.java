package slowboat.slowboat.repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;
import slowboat.slowboat.model.Entity.QBoat;
import slowboat.slowboat.model.Entity.QWriter;

import javax.persistence.EntityManager;
import java.beans.Expression;
import java.util.List;

import static slowboat.slowboat.model.Entity.QBoat.*;
import static slowboat.slowboat.model.Entity.QWriter.*;

public class BoatRepositoryImpl implements BoatRepositoryCustom{


   private final JPAQueryFactory jpaQueryFactory;

   BoatRepositoryImpl(EntityManager entityManager){
       this.jpaQueryFactory = new JPAQueryFactory(entityManager);
   }

    /**
     *  제일 최신 Boat return
     */
   @Override
    public Boat findMaxBoat() {

       Boat findBoat = jpaQueryFactory
               .select(boat)
               .where(
                       boat.id.eq(
                                JPAExpressions
                               .select(boat.id.max())
                               .from(boat)
                        )
               ).fetchOne();


       return findBoat;
    }

    /**
     *  가장 큰 boat id 출력
     */
    @Override
    public int findMaxBoatId() {
        Integer max = jpaQueryFactory
                .select(boat.id.max())
                .from(boat)
                .fetchOne();

        return max;
    }

    /**
     *  random boat 하나 출력
     */
    @Override
    public Boat findBoatRandomly() {
        Boat findBoat = jpaQueryFactory
                .select(boat)
                .from(boat)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                .fetchFirst();

        return findBoat;
    }

    @Override
    public Page<Boat> getBoatByCategory(Category category, Pageable pageable) {
        List<Boat> boats = jpaQueryFactory
                .select(boat)
                .from(boat)
                .join(boat.writer, writer).fetchJoin()
                .where(boat.category.eq(category))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(boat.id.desc())
                .fetch();

        for (Boat boat1 : boats) {

            System.out.println("boat1.getContent() = " + boat1.getContent());
        }

        System.out.println("nmixxxxxxxxxxxxxx 0과 1의 미로가 봐여" );
        System.out.println(category);
        JPAQuery<Long> countQuery = jpaQueryFactory
                .select(boat.count())
                .from(boat)
                .where(boat.category.eq(category));


        return PageableExecutionUtils.getPage(boats, pageable, countQuery::fetchOne);
    }
}
