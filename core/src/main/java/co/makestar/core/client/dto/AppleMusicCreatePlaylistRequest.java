package co.makestar.core.client.dto;

public record AppleMusicCreatePlaylistRequest(Attributes attributes, Relationships relationships) {

    public record Attributes(String description, String name) {

    }

    public record Relationships(Tracks tracks, Parent parent) {

    }

    public record Tracks(Data data) {

    }

    public record Parent(Data data) {

    }

    public record Data(String id, String type) {

    }
}
