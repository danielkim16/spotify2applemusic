package co.makestar.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tracks")
public class Tracks extends BaseCreatedAtAndUpdatedAtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column(name = "platform_track_id")
    private String platformTrackId;

    @Column(nullable = false)
    private String isrc;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @Column(name = "track_name", nullable = false)
    private String trackName;

    @Column(name = "artist_name", nullable = false)
    private String artistName;

    @Column(name = "cover_image_url", nullable = false)
    private String coverImageUrl;

    @Column(nullable = false)
    private boolean published;

    @Column(nullable = false)
    private boolean synced;
}
