package co.makestar.core.client.dto;

import co.makestar.core.service.dto.CreatePlaylist;
import lombok.Builder;

@Builder
public record AppleMusicCreatePlaylistRequest(Attributes attributes, Relationships relationships) {

    @Builder
    public record Attributes(String description, String name) {

    }

    @Builder
    public record Relationships(Tracks tracks, Parent parent) {

    }

    @Builder
    public record Tracks(Data data) {

    }

    @Builder
    public record Parent(Data data) {

    }

    @Builder
    public record Data(String id, String type) {

    }

    public static AppleMusicCreatePlaylistRequest of(String title, String description, String parentId,
                                                     String parentType, String trackId, String trackType) {

        Attributes attributes = Attributes.builder()
                                          .description(description)
                                          .name(title)
                                          .build();
        Parent parent = Parent.builder()
                              .data(Data.builder()
                                        .id(parentId)
                                        .type(parentType)
                                        .build())
                              .build();
        Tracks tracks = Tracks.builder()
                              .data(Data.builder()
                                        .id(trackId)
                                        .type(trackType)
                                        .build())
                              .build();
        Relationships relationships = Relationships.builder()
                                                   .parent(parent)
                                                   .tracks(tracks)
                                                   .build();

        return AppleMusicCreatePlaylistRequest.builder()
                                              .attributes(attributes)
                                              .relationships(relationships)
                                              .build();
    }
}
