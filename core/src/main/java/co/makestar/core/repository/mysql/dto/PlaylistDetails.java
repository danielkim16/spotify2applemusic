package co.makestar.core.repository.mysql.dto;

public record PlaylistDetails(
    Long playlistId,
//    Long trackId,
//    String platformPlaylistId,
    String title,
    Long trackId,
//    String platform,
    String isrc,
    String trackName,
    String artistName,
    String albumName,
    String coverImageUrl,
    boolean published
) {
    public PlaylistDetails(Long playlistId, String title, Long trackId, String isrc, String trackName, String artistName, String albumName, String coverImageUrl, boolean published) {
        this.playlistId = playlistId;
        this.title = title;
        this.trackId = trackId;
        this.isrc = isrc;
        this.trackName = trackName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.coverImageUrl = coverImageUrl;
        this.published = published;
    }
}
