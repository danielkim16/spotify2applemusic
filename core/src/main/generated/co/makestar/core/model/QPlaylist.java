package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaylist is a Querydsl query type for Playlist
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaylist extends EntityPathBase<Playlist> {

    private static final long serialVersionUID = 1387161050L;

    public static final QPlaylist playlist = new QPlaylist("playlist");

    public final QBaseCreatedAtAndUpdatedAtEntity _super = new QBaseCreatedAtAndUpdatedAtEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Platform> platform = createEnum("platform", Platform.class);

    public final StringPath platformPlaylistId = createString("platformPlaylistId");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> updatedAt = _super.updatedAt;

    public QPlaylist(String variable) {
        super(Playlist.class, forVariable(variable));
    }

    public QPlaylist(Path<? extends Playlist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaylist(PathMetadata metadata) {
        super(Playlist.class, metadata);
    }

}

