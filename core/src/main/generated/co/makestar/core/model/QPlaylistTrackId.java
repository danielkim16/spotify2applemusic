package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaylistTrackId is a Querydsl query type for PlaylistTrackId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPlaylistTrackId extends BeanPath<PlaylistTrackId> {

    private static final long serialVersionUID = 1570741388L;

    public static final QPlaylistTrackId playlistTrackId = new QPlaylistTrackId("playlistTrackId");

    public final NumberPath<Long> playlistId = createNumber("playlistId", Long.class);

    public final NumberPath<Long> trackId = createNumber("trackId", Long.class);

    public QPlaylistTrackId(String variable) {
        super(PlaylistTrackId.class, forVariable(variable));
    }

    public QPlaylistTrackId(Path<? extends PlaylistTrackId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaylistTrackId(PathMetadata metadata) {
        super(PlaylistTrackId.class, metadata);
    }

}

