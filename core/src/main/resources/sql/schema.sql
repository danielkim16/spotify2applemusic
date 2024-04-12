CREATE TABLE `playlist`
(
    `id`                        BIGINT(20) NOT NULL AUTO_INCREMENT,
    `platform`                  VARCHAR(50) NOT NULL,
    `platform_playlist_id`      VARCHAR(50) NOT NULL,
    `title`                     VARCHAR(255) NOT NULL COMMENT '제목',
    `synced`                BOOLEAN NOT NULL DEFAULT 0 COMMENT '동기화 여부',
    `created_at`                TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    `updated_at`                TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
    PRIMARY KEY (`id`),
    UNIQUE INDEX idx_platform_track_id (platform, platform_playlist_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT 'playlist';

CREATE TABLE `tracks`
(
    `id`                    BIGINT(20) NOT NULL AUTO_INCREMENT,
    `platform`              VARCHAR(50) NOT NULL,
    `platform_track_id`     VARCHAR(50) NULL,
    `isrc`                  VARCHAR(20) NOT NULL COMMENT 'international standard recording code',
    `album_name`            VARCHAR(255) NOT NULL COMMENT '앨범 이름',
    `track_name`            VARCHAR(255) NOT NULL COMMENT '트랙 이름',
    `artist_name`           VARCHAR(255) NOT NULL COMMENT '아티스트 이름',
    `cover_image_url`       VARCHAR(255) NOT NULL COMMENT '표지 이미지 URL',
    `published`             BOOLEAN NOT NULL COMMENT '배포 여부',
    `synced`                BOOLEAN NOT NULL DEFAULT 0 COMMENT '동기화 여부',
    `created_at`            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    `updated_at`            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
    PRIMARY KEY (`id`),
    UNIQUE INDEX idx_platform_track_id (platform, platform_track_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT 'tracks';

CREATE TABLE `playlist_tracks`
(
    `playlist_id`               BIGINT(20) NOT NULL,
    `track_id`                  BIGINT(20) NOT NULL,
    `created_at`                TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    PRIMARY KEY (`playlist_id`,`track_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT 'playlist tracks mapping';
