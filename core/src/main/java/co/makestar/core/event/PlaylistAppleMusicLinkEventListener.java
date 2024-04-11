package co.makestar.core.event;

import co.makestar.core.model.event.PlaylistAppleMusicLinkCompleteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class PlaylistAppleMusicLinkEventListener {

//    private final PlaylistSpotifyService playlistSpotifyService;
//
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    void linkComplete(PlaylistAppleMusicLinkCompleteEvent event) {
//        log.info("apple music link complete. cache refresh start playlistId: % s".formatted(event.couponId()));
//        couponCacheService.putCouponCache(event.couponId());
//        couponCacheService.putCouponLocalCache(event.couponId());
//        log.info("issue complete cache refresh end couponId: %s".formatted(event.couponId()));
//    }
}
