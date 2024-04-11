package co.makestar.core.service;

import static org.junit.jupiter.api.Assertions.*;

import co.makestar.core.CoreConfiguration;
import co.makestar.core.model.Platform;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "spring.config.name=application-core")
@ActiveProfiles("local")
@SpringBootTest(classes = CoreConfiguration.class)
class PlaylistServiceTest {

    @Autowired
    private PlaylistService playlistService;

    @Test
    void findAllOfPlaylistDetails() {
    }

    @Test
    void requestAppleMusicLink() {
        playlistService.updateAppleMusic("PLAYLIST-ID-1");
    }
}