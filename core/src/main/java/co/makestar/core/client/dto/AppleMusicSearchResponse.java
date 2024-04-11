package co.makestar.core.client.dto;

import java.util.List;
import java.util.Map;

public record AppleMusicSearchResponse(List<DataItem> data, Meta meta) {

    public record DataItem(String id, String type, String href, Attributes attributes, Relationships relationships) {
    }

    public record Attributes(
        String albumName,
        List<String> genreNames,
        Integer trackNumber,
        String releaseDate,
        Integer durationInMillis,
        String isrc,
        Artwork artwork,
        String composerName,
        PlayParams playParams,
        String url,
        Integer discNumber,
        Boolean hasCredits,
        Boolean isAppleDigitalMaster,
        Boolean hasLyrics,
        String name,
        List<Preview> previews,
        String artistName) {
    }

    public record Artwork(
        Integer width,
        Integer height,
        String url,
        String bgColor,
        String textColor1,
        String textColor2,
        String textColor3,
        String textColor4) {
    }

    public record PlayParams(String id, String kind) {
    }

    public record Preview(String url) {
    }

    public record Relationships(ArtistData artists, AlbumData albums) {
    }

    public record ArtistData(String href, List<Artist> data) {
    }

    public record Artist(String id, String type, String href) {
    }

    public record AlbumData(String href, List<Album> data) {
    }

    public record Album(String id, String type, String href) {
    }

    public record Meta(Map<String, Map<String, List<FilterItem>>> filters) {
    }

    public record FilterItem(String id, String type, String href) {
    }
}








