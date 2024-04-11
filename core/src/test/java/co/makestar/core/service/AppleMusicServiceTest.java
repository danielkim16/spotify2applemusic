package co.makestar.core.service;

import co.makestar.core.CoreConfiguration;
import co.makestar.core.client.dto.AppleMusicSearchResponse;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import reactor.test.StepVerifier;

@TestPropertySource(properties = "spring.config.name=application-core")
@ActiveProfiles("local")
@SpringBootTest(classes = CoreConfiguration.class)
class AppleMusicServiceTest {

    @Autowired
    AppleMusicService appleMusicService;

    @Test
    void search() {
        AppleMusicSearchResponse response = appleMusicService.search("USA2P2330067");
    }

//    @Test
//    void searchAll() {
//        List<String> list = Arrays.asList("USA2P2254487", "USA2P2230221", "USA2P2330067", "USA2P2254487", "USA2P2360920");
//
//        StepVerifier.create(appleMusicService.searchAll(list).log())
//                    .expectNextCount(5)
//                    .verifyComplete();
//    }
}