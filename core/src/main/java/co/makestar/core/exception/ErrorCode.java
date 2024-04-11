package co.makestar.core.exception;

public enum ErrorCode {
    PLAYLIST_NOT_EXIST("존재하지 않는 플레이리스트입니다.");

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
