package co.makestar.core.service;

import co.makestar.core.model.Platform;
import co.makestar.core.repository.mysql.PlaylistJpaRepository;
import co.makestar.core.repository.mysql.PlaylistRepository;
import co.makestar.core.repository.mysql.PlaylistTracksJpaRepository;
import co.makestar.core.repository.mysql.TracksJpaRepository;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import co.makestar.core.repository.redis.RedisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistJpaRepository playlistJpaRepository;
    private final TracksJpaRepository tracksJpaRepository;
    private final PlaylistTracksJpaRepository playlistTracksJpaRepository;
    private final PlaylistRepository playlistRepository;
    private final AppleMusicService appleMusicService;
    private final RedisRepository redisRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional(readOnly = true)
    public List<PlaylistDetails> findPlaylist(Platform platform, String platformPlaylistId, Long trackId, Integer pageSize) {
        pageSize = pageSize == null ? 10 : pageSize;

        return playlistRepository.findPlaylist(platform, platformPlaylistId, trackId, pageSize);
    }

    public void updateAppleMusic(String platformPlaylistId) {
        Long trackId = 0L;
        Integer pageSize = 10;

        List<PlaylistDetails> spotifyPlaylist = playlistRepository.findPlaylist(Platform.SPOTIFY, platformPlaylistId, trackId, pageSize);

        spotifyPlaylist.stream()
                       .map(playlist -> appleMusicService.search(playlist.isrc()))
                       .forEach(appleMusicSearchResponse -> {
                           appleMusicSearchResponse.data().stream().forEach(data -> {
                               // TODO Apple Music 데이터 없데이트
                           });
                       });
    }

//    @Transactional
//    public void saveAppleMusic(AppleMusicSearchResponse.DataItem response) {
//        Playlist playlist = Playlist.builder()
//                                    .title()
//                                    .platformPlaylistId()
//                                    .platform()
//                                    .build();
//        PlaylistTracks playlistTracks = PlaylistTracks.builder()
//                                                      .playlistId()
//                                                      .trackId()
//                                                      .build();
//        Tracks tracks = Tracks.builder()
//                              .isrc()
//                              .albumName()
//                              .platformTrackId()
//                              .artistName()
//                              .coverImageUrl()
//                              .trackName()
//                              .synced()
//                              .published()
//                              .platform()
//                              .trackName()
//                              .build();
//
//        playlistJpaRepository.save(playlist);
//        tracksJpaRepository.save(tracks);
//        playlistTracksJpaRepository.save(playlistTracks);
//    }

    public void linkAppleMusic() {
        // TODO Apple Music 연동하기

        //        AppleMusicCreatePlaylistResponse appleMusicCreatePlaylistResponse = appleMusicService.createPlaylist(new AppleMusicCreatePlaylistRequest(
//            new AppleMusicCreatePlaylistRequest.Attributes("", ""),
//            new AppleMusicCreatePlaylistRequest.Relationships(
//                new AppleMusicCreatePlaylistRequest.Tracks(
//                    new AppleMusicCreatePlaylistRequest.Data("", "")
//                ),
//                new AppleMusicCreatePlaylistRequest.Parent(
//                    new AppleMusicCreatePlaylistRequest.Data("", "")
//                )
//            ))).block();
    }
}
