package co.makestar.api.controller;

import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import co.makestar.core.service.SpotifyPlaylistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SpotifyPlaylistController {

    private final SpotifyPlaylistService spotifyPlaylistService;

    @GetMapping("/v1/spotify/playlist/{playlistId}")
    public List<PlaylistDetails> getPlaylist(@PathVariable(value = "playlistId") Long playlistId,
                                             @RequestParam(value = "trackId", required = false) Long trackId,
                                             @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return spotifyPlaylistService.findPlaylist(playlistId, trackId, pageSize);
    }
}
