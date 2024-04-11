package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaylistTracks is a Querydsl query type for PlaylistTracks
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaylistTracks extends EntityPathBase<PlaylistTracks> {

    private static final long serialVersionUID = -1888993534L;

    public static final QPlaylistTracks playlistTracks = new QPlaylistTracks("playlistTracks");

    public final QBaseCreatedAtEntity _super = new QBaseCreatedAtEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> playlistId = createNumber("playlistId", Long.class);

    public final NumberPath<Long> trackId = createNumber("trackId", Long.class);

    public QPlaylistTracks(String variable) {
        super(PlaylistTracks.class, forVariable(variable));
    }

    public QPlaylistTracks(Path<? extends PlaylistTracks> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaylistTracks(PathMetadata metadata) {
        super(PlaylistTracks.class, metadata);
    }

}

