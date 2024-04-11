package co.makestar.core.repository.mysql;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TracksRepository {

    private final JPQLQueryFactory queryFactory;

//    public CouponIssue findBy(long couponId, long userId) {
//        return queryFactory.selectFrom(couponIssue)
//                .where(couponIssue.couponId.eq(couponId))
//                .where(couponIssue.userId.eq(userId))
//                .fetchFirst();
//    }
}
