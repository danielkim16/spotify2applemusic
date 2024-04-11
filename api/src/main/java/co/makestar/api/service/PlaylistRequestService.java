package co.makestar.api.service;

import co.makestar.core.client.AppleMusicClient;
import co.makestar.core.client.dto.AppleMusicSearchResponse;
import co.makestar.core.service.PlaylistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlaylistRequestService {

    private final PlaylistService playlistService;
    private final AppleMusicClient appleMusicClient;


}
