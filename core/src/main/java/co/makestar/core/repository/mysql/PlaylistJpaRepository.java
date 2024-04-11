package co.makestar.core.repository.mysql;

import co.makestar.core.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistJpaRepository extends JpaRepository<Playlist, Long> {
}
