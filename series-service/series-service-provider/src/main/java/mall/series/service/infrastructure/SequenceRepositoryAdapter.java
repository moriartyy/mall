package mall.series.service.infrastructure;

import lombok.RequiredArgsConstructor;
import mall.series.service.domain.SequenceId;
import mall.series.service.domain.SequenceRepository;
import mall.series.service.domain.SequenceSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SequenceRepositoryAdapter implements SequenceRepository {

    public static final String CREATE_SEQUENCE_SQL = "INSERT IGNORE INTO sequence " +
            "(series_id, epoch, current_value) VALUES (?, ?, ?)";

    public static final String UPDATE_SEQUENCE_SQL = "UPDATE sequence " +
            "SET current_value = LAST_INSERT_ID(current_value + ?) " +
            "WHERE series_id=? AND epoch=?";

    public static final String DELETE_SEQUENCE_SQL = "DELETE FROM sequence WHERE series_id=? AND epoch=?";

    public static final String DELETE_SERIES_SEQUENCES_SQL = "DELETE FROM sequence WHERE series_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public SequenceSegment getSegment(SequenceId sequenceId, Integer count) {
        Optional<Long> newValue = update(sequenceId, count);
        if (!newValue.isPresent()) {
            newValue = create(sequenceId, count);
        }
        if (!newValue.isPresent()) {
            newValue = update(sequenceId, count);
        }

        if (!newValue.isPresent()) {
            throw new IllegalStateException("Can not create or update sequence");
        }
        return new SequenceSegment(sequenceId, count, newValue.get());
    }

    public Optional<Long> update(SequenceId sequenceId, Integer count) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SEQUENCE_SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, count);
            statement.setInt(2, sequenceId.getSeriesId());
            statement.setInt(3, sequenceId.getEpoch());
            return statement;
        }, keyHolder);
        return (affectedRows > 0) ? Optional.of(Objects.requireNonNull(keyHolder.getKey()).longValue()) : Optional.empty();
    }

    public Optional<Long> create(SequenceId sequenceId, Integer count) {
        int affectedRows = jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(CREATE_SEQUENCE_SQL);
            statement.setInt(1, sequenceId.getSeriesId());
            statement.setInt(2, sequenceId.getEpoch());
            statement.setLong(3, count);
            return statement;
        });
        return (affectedRows > 0) ? Optional.of(count.longValue()) : Optional.empty();
    }

    public int delete(SequenceId sequenceId) {
        return jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(DELETE_SEQUENCE_SQL);
            statement.setInt(1, sequenceId.getSeriesId());
            statement.setInt(2, sequenceId.getEpoch());
            return statement;
        });
    }

    public int deleteAllBySeriesId(int seriesId) {
        return jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(DELETE_SERIES_SEQUENCES_SQL);
            statement.setInt(1, seriesId);
            return statement;
        });
    }
}
