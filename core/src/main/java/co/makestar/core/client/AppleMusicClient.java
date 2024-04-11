package co.makestar.core.client;

import co.makestar.core.client.dto.AppleMusicCreatePlaylistRequest;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistResponse;
import co.makestar.core.client.dto.AppleMusicCreateTracksRequest;
import co.makestar.core.client.dto.AppleMusicCreateTracksResponse;
import co.makestar.core.client.dto.AppleMusicSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AppleMusicClient {

    @Value("${apple-music.url}")
    private String url;

    @Value("${apple-music.access-token}")
    private String accessToken;

    private final WebClient webClient;

    public Mono<AppleMusicCreatePlaylistResponse> createPlaylist(AppleMusicCreatePlaylistRequest request) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl(url)
            .path("/v1/me/library/playlists")
            .buildAndExpand()
            .toUriString();
        return webClient
            .post()
            .uri(uriString)
            .header("Authorization", "Bearer %s".formatted(accessToken))
            .bodyValue(request)
            .retrieve()
            .bodyToMono(AppleMusicCreatePlaylistResponse.class);
    }

    public Mono<AppleMusicCreateTracksResponse> createTracks(String appleMusicPlaylistId, AppleMusicCreateTracksRequest request) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl(url)
            .path("/v1/me/library/playlists/%s/tracks".formatted(appleMusicPlaylistId))
            .buildAndExpand()
            .toUriString();

        return webClient
            .post()
            .uri(uriString)
            .header("Authorization", "Bearer %s".formatted(accessToken))
            .bodyValue(request)
            .retrieve()
            .bodyToMono(AppleMusicCreateTracksResponse.class);
    }

    public Mono<AppleMusicSearchResponse> searchByIsrc(String isrc) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl(url)
            .path("/v1/catalog/us/songs?filter[isrc]=%s".formatted(isrc))
            .buildAndExpand()
            .toUriString();

        return webClient
            .get()
            .uri(uriString)
            .header("Authorization", "Bearer %s".formatted(accessToken))
            .retrieve()
            .bodyToMono(AppleMusicSearchResponse.class);
    }
}
