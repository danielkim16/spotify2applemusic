package co.makestar.core.client.dto;

public record AppleMusicCreateTracksRequest(Data data) {
    public record Data(String id, String type) {

    }
}
