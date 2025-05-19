package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QStore;
import umc.spring.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final QStore store = QStore.store;


    /**
     * booleanBuilder를 사용한 동적 쿼리
     * @param name
     * @param score
     * @return
     */
    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(name!=null) {
            booleanBuilder.and(store.name.eq(name));
        }

        if(score != null) {
            booleanBuilder.and(store.score.goe(4.0f));
        }


        return queryFactory.select(store)
                .from(store)
                .where(booleanBuilder)
                .fetch();

    }
}
