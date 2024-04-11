package co.makestar.core.repository.mysql;

import co.makestar.core.model.Playlist;
import co.makestar.core.model.PlaylistTrackId;
import co.makestar.core.model.PlaylistTracks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistTracksJpaRepository extends JpaRepository<PlaylistTracks, PlaylistTrackId> {
}
