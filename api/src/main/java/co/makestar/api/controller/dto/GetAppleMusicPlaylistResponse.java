package co.makestar.api.controller.dto;

import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import java.util.List;

public record GetAppleMusicPlaylistResponse(List<PlaylistDetails> playlist) {

    public static GetAppleMusicPlaylistResponse of(List<PlaylistDetails> playlist) {
        return new GetAppleMusicPlaylistResponse(playlist);
    }
}
