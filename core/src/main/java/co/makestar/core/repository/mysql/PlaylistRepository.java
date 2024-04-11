package co.makestar.core.repository.mysql;

import static co.makestar.core.model.QPlaylist.playlist;
import static co.makestar.core.model.QPlaylistTracks.playlistTracks;
import static co.makestar.core.model.QTracks.tracks;
import static com.querydsl.core.types.Projections.constructor;

import co.makestar.core.model.Platform;
import co.makestar.core.repository.mysql.dto.PlaylistDetails;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PlaylistRepository {

    private final JPQLQueryFactory queryFactory;

    public List<PlaylistDetails> findPlaylist(Platform platform, String platformPlaylistId, Long trackId, int pageSize) {
        return queryFactory.select(
                               constructor(
                                   PlaylistDetails.class,
                                   playlist.id,
                                   playlist.title,
                                   tracks.id,
                                   tracks.isrc,
                                   tracks.trackName,
                                   tracks.artistName,
                                   tracks.albumName,
                                   tracks.coverImageUrl,
                                   tracks.published
                               )
                           )
                           .from(playlist)
                           .join(playlistTracks).on(playlist.id.eq(playlistTracks.playlistId))
                           .join(tracks).on(tracks.id.eq(playlistTracks.trackId))
                           .where(
                               playlist.platformPlaylistId.eq(platformPlaylistId),
                               playlist.platform.eq(platform),
                               gtTrackId(trackId)
                           )
                           .limit(pageSize)
                           .fetch();
    }

    public List<String> findIsrcList(Platform platform, String platformPlaylistId, Long trackId, int pageSize) {
        return queryFactory.select(tracks.isrc)
                           .from(playlist)
                           .join(playlistTracks).on(playlist.id.eq(playlistTracks.playlistId))
                           .join(tracks).on(tracks.id.eq(playlistTracks.trackId))
                           .where(
                               playlist.platform.eq(platform),
                               playlist.platformPlaylistId.eq(platformPlaylistId),
                               gtTrackId(trackId)
                           )
                           .limit(pageSize)
                           .fetch();
    }

    private BooleanExpression gtTrackId(Long trackId) {
        if (trackId == null) {
            return null;
        }

        return tracks.id.gt(trackId);
    }
}
