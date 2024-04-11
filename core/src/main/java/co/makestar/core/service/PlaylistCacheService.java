package co.makestar.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaylistCacheService {

//    private final CouponIssueService couponIssueService;
//
//    @Cacheable(cacheNames = "coupon")
//    public CouponRedisEntity getCouponCache(long couponId) {
//        Coupon coupon = couponIssueService.findCoupon(couponId);
//        return new CouponRedisEntity(coupon);
//    }
//
//    @CachePut(cacheNames = "coupon")
//    public CouponRedisEntity putCouponCache(long couponId) {
//        return getCouponCache(couponId);
//    }
}