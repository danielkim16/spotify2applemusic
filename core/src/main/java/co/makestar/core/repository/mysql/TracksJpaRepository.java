package co.makestar.core.repository.mysql;

import co.makestar.core.model.Tracks;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TracksJpaRepository extends JpaRepository<Tracks, Long> {
}
