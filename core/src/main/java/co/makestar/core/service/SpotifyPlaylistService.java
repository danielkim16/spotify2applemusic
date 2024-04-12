package co.makestar.core.service;

import co.makestar.core.model.Platform;
import co.makestar.core.repository.mysql.PlaylistRepository;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotifyPlaylistService {

    private final PlaylistRepository playlistRepository;

    @Transactional(readOnly = true)
    public List<PlaylistDetails> findPlaylist(Long playlistId, Long trackId, Integer pageSize) {
        pageSize = pageSize == null ? 10 : pageSize;

        return playlistRepository.findPlaylist(Platform.SPOTIFY, playlistId, trackId, pageSize);
    }
}
