package co.makestar.api.controller;

import co.makestar.core.model.Platform;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import co.makestar.core.service.PlaylistService;
import io.lettuce.core.dynamic.annotation.Param;
import jakarta.annotation.Nullable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/v1/playlist/{platform}/{platformPlaylistId}")
    public List<PlaylistDetails> getPlaylist(@PathVariable(value = "platform") Platform platform,
                                             @PathVariable(value = "platformPlaylistId") String platformPlaylistId,
                                             @RequestParam(value = "trackId", required = false) Long trackId,
                                             @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return playlistService.findPlaylist(platform, platformPlaylistId, trackId, pageSize);
    }

}
