package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTracks is a Querydsl query type for Tracks
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTracks extends EntityPathBase<Tracks> {

    private static final long serialVersionUID = -1572372848L;

    public static final QTracks tracks = new QTracks("tracks");

    public final QBaseCreatedAtAndUpdatedAtEntity _super = new QBaseCreatedAtAndUpdatedAtEntity(this);

    public final StringPath albumName = createString("albumName");

    public final StringPath artistName = createString("artistName");

    public final StringPath coverImageUrl = createString("coverImageUrl");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isrc = createString("isrc");

    public final EnumPath<Platform> platform = createEnum("platform", Platform.class);

    public final StringPath platformTrackId = createString("platformTrackId");

    public final BooleanPath published = createBoolean("published");

    public final BooleanPath synced = createBoolean("synced");

    public final StringPath trackName = createString("trackName");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> updatedAt = _super.updatedAt;

    public QTracks(String variable) {
        super(Tracks.class, forVariable(variable));
    }

    public QTracks(Path<? extends Tracks> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTracks(PathMetadata metadata) {
        super(Tracks.class, metadata);
    }

}

