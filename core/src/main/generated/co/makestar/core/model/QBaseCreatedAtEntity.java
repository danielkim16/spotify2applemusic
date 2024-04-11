package co.makestar.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseCreatedAtEntity is a Querydsl query type for BaseCreatedAtEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseCreatedAtEntity extends EntityPathBase<BaseCreatedAtEntity> {

    private static final long serialVersionUID = 1513357541L;

    public static final QBaseCreatedAtEntity baseCreatedAtEntity = new QBaseCreatedAtEntity("baseCreatedAtEntity");

    public final DateTimePath<java.time.ZonedDateTime> createdAt = createDateTime("createdAt", java.time.ZonedDateTime.class);

    public QBaseCreatedAtEntity(String variable) {
        super(BaseCreatedAtEntity.class, forVariable(variable));
    }

    public QBaseCreatedAtEntity(Path<? extends BaseCreatedAtEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseCreatedAtEntity(PathMetadata metadata) {
        super(BaseCreatedAtEntity.class, metadata);
    }

}

