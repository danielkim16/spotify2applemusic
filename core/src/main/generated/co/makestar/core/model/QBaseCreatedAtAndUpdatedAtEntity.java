package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseCreatedAtAndUpdatedAtEntity is a Querydsl query type for BaseCreatedAtAndUpdatedAtEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseCreatedAtAndUpdatedAtEntity extends EntityPathBase<BaseCreatedAtAndUpdatedAtEntity> {

    private static final long serialVersionUID = 1087382268L;

    public static final QBaseCreatedAtAndUpdatedAtEntity baseCreatedAtAndUpdatedAtEntity = new QBaseCreatedAtAndUpdatedAtEntity("baseCreatedAtAndUpdatedAtEntity");

    public final DateTimePath<java.time.ZonedDateTime> createdAt = createDateTime("createdAt", java.time.ZonedDateTime.class);

    public final DateTimePath<java.time.ZonedDateTime> updatedAt = createDateTime("updatedAt", java.time.ZonedDateTime.class);

    public QBaseCreatedAtAndUpdatedAtEntity(String variable) {
        super(BaseCreatedAtAndUpdatedAtEntity.class, forVariable(variable));
    }

    public QBaseCreatedAtAndUpdatedAtEntity(Path<? extends BaseCreatedAtAndUpdatedAtEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseCreatedAtAndUpdatedAtEntity(PathMetadata metadata) {
        super(BaseCreatedAtAndUpdatedAtEntity.class, metadata);
    }

}

