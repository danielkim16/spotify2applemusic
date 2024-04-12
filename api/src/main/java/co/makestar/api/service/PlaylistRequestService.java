package co.makestar.api.service;

import co.makestar.core.client.AppleMusicClient;
import co.makestar.core.service.SpotifyPlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistRequestService {

    private final SpotifyPlaylistService spotifyPlaylistService;
    private final AppleMusicClient appleMusicClient;


}
