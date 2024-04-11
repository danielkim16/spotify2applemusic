package co.makestar.core.service;

import co.makestar.core.client.AppleMusicClient;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistRequest;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistResponse;
import co.makestar.core.client.dto.AppleMusicCreateTracksRequest;
import co.makestar.core.client.dto.AppleMusicCreateTracksResponse;
import co.makestar.core.client.dto.AppleMusicSearchResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AppleMusicService {

    private final AppleMusicClient appleMusicClient;

    public AppleMusicSearchResponse search(String isrc) {
        return appleMusicClient.searchByIsrc(isrc).block();
    }

//    public Flux<AppleMusicSearchResponse> searchAll(List<String> isrcList) {
//        return Flux.fromIterable(isrcList)
//                   .flatMap(this::search, 5);
//    }

    public AppleMusicCreatePlaylistResponse createPlaylist(AppleMusicCreatePlaylistRequest request) {
        return appleMusicClient.createPlaylist(request).block();
    }

    public AppleMusicCreateTracksResponse createTracks(String appleMusicPlaylistId, AppleMusicCreateTracksRequest request) {
        return appleMusicClient.createTracks(appleMusicPlaylistId, request).block();
    }
}
