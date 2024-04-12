package co.makestar.api.controller;

import co.makestar.api.controller.dto.CreateAppleMusicPlaylistRequest;
import co.makestar.api.controller.dto.CreateAppleMusicPlaylistResponse;
import co.makestar.api.controller.dto.CreateAppleMusicTracksResponse;
import co.makestar.api.controller.dto.GetAppleMusicPlaylistResponse;
import co.makestar.core.model.Platform;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import co.makestar.core.service.AppleMusicPlaylistService;
import co.makestar.core.service.SpotifyPlaylistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AppleMusicPlaylistController {

    private final AppleMusicPlaylistService appleMusicPlaylistService;

    @GetMapping("/v1/apple-music/playlist/{platformPlaylistId}")
    public GetAppleMusicPlaylistResponse getPlaylist(@PathVariable(value = "platformPlaylistId") String platformPlaylistId,
                                                     @RequestParam(value = "trackId", required = false) Long trackId,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return GetAppleMusicPlaylistResponse.of(appleMusicPlaylistService.findPlaylist(platformPlaylistId, trackId, pageSize));
    }

    @PostMapping("/v1/apple-music/playlist")
    public CreateAppleMusicPlaylistResponse createPlaylist(@RequestBody CreateAppleMusicPlaylistRequest request) {
        appleMusicPlaylistService.createPlaylist(request.createPlaylist());

        return new CreateAppleMusicPlaylistResponse();
    }

    @PostMapping("/v1/apple-music/tracks")
    public CreateAppleMusicTracksResponse createTracks(@RequestBody CreateAppleMusicPlaylistRequest request) {

        // TODO Apple Music Tracks에 추가하고 DB에 저장하는 처리해야 합니다.

        return new CreateAppleMusicTracksResponse();
    }
}
