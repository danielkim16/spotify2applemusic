package co.makestar.core.service;

import co.makestar.core.client.AppleMusicClient;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistRequest;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistRequest.Attributes;
import co.makestar.core.client.dto.AppleMusicCreatePlaylistResponse;
import co.makestar.core.client.dto.AppleMusicCreateTracksRequest;
import co.makestar.core.client.dto.AppleMusicCreateTracksResponse;
import co.makestar.core.client.dto.AppleMusicSearchResponse;
import co.makestar.core.model.Platform;
import co.makestar.core.model.Playlist;
import co.makestar.core.repository.mysql.PlaylistJpaRepository;
import co.makestar.core.repository.mysql.PlaylistRepository;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import co.makestar.core.service.dto.CreatePlaylist;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppleMusicPlaylistService {

    private final AppleMusicClient appleMusicClient;
    private final PlaylistRepository playlistRepository;
    private final PlaylistJpaRepository playlistJpaRepository;

    @Transactional(readOnly = true)
    public List<PlaylistDetails> findPlaylist(Long playlistId, Long trackId, Integer pageSize) {
        pageSize = pageSize == null ? 10 : pageSize;

        return playlistRepository.findPlaylist(Platform.APPLE_MUSIC, playlistId, trackId, pageSize);
    }

    public AppleMusicSearchResponse search(String isrc) {
        return appleMusicClient.searchByIsrc(isrc).block();
    }

//    public Flux<AppleMusicSearchResponse> searchAll(List<String> isrcList) {
//        return Flux.fromIterable(isrcList)
//                   .flatMap(this::search, 5);
//    }

    public void createPlaylist(CreatePlaylist createPlaylist) {
        AppleMusicCreatePlaylistResponse response = requestToAppleMusic(createPlaylist);

        String playlistId = null;
        boolean synced = false;

        if (response != null) {
            playlistId = this.findPlaylistId(createPlaylist, response.data());
            synced = true;
        }

        playlistJpaRepository.save(toPlaylist(playlistId, synced, createPlaylist));
    }

    private String findPlaylistId(CreatePlaylist createPlaylist,
                                  List<AppleMusicCreatePlaylistResponse.LibraryPlaylistData> datas) {

        // TODO Apple Music Playlist 데이터를 확인해보고 정확한 playlistId를 찾아서 리턴합니다.

        return datas.get(0).id();
    }


    private AppleMusicCreatePlaylistResponse requestToAppleMusic(CreatePlaylist createPlaylist) {
        try {
            return appleMusicClient.createPlaylist(toAppleMusicCreatePlaylistRequest(createPlaylist)).block();
        } catch (Exception e) {
            // TODO FailQueue 재처리 필요
            log.error("Apple Music에 Playlist를 생성하는데 실패하였습니다.", e);
        }
        return null;
    }

    private Playlist toPlaylist(String playlistId, boolean synced, CreatePlaylist createPlaylist) {
        return Playlist.builder()
                       .title(createPlaylist.title())
                       .platform(Platform.APPLE_MUSIC)
                       .platformPlaylistId(playlistId)
                       .synced(synced)
                       .build();
    }

    private AppleMusicCreatePlaylistRequest toAppleMusicCreatePlaylistRequest(CreatePlaylist createPlaylist) {
        return AppleMusicCreatePlaylistRequest.of(createPlaylist.title(), createPlaylist.description(),
                                                  createPlaylist.parentId(), createPlaylist.parentType(),
                                                  createPlaylist.trackId(), createPlaylist.trackType());
    }

    public AppleMusicCreateTracksResponse createTracks(String appleMusicPlaylistId, AppleMusicCreateTracksRequest request) {
        return appleMusicClient.createTracks(appleMusicPlaylistId, request).block();
    }
}
