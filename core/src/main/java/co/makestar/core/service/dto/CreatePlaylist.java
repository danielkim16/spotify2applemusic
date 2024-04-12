package co.makestar.core.service.dto;

public record CreatePlaylist(String title, String description, String parentId, String parentType,
                             String trackId, String trackType) {

}
