package co.makestar.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "playlist_tracks")
@IdClass(PlaylistTrackId.class)
public class PlaylistTracks extends BaseCreatedAtEntity {

    @Id
    @Column(name = "playlist_id")
    private Long playlistId;

    @Id
    @Column(name = "track_id")
    private Long trackId;
}