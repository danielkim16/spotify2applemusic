package co.makestar.core.service;

import co.makestar.core.CoreConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "spring.config.name=application-core")
@ActiveProfiles("local")
@SpringBootTest(classes = CoreConfiguration.class)
class SpotifyPlaylistServiceTest {

    @Autowired
    private SpotifyPlaylistService spotifyPlaylistService;

    @Test
    void findAllOfPlaylistDetails() {
    }
}