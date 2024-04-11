package co.makestar.core.client.dto;

import java.util.List;

public record AppleMusicCreatePlaylistResponse(List<LibraryPlaylistData> data) {

    public record LibraryPlaylistData(String id, String type, String href, Attributes attributes) {

    }

    public record Attributes(
        Boolean hasCatalog,
        Description description,
        String name,
        Boolean canEdit,
        Boolean isPublic,
        PlayParams playParams,
        String dateAdded
    ) {

    }

    public record Description(String standard) {

    }

    public record PlayParams(String id, String kind, Boolean isLibrary) {

    }
}
