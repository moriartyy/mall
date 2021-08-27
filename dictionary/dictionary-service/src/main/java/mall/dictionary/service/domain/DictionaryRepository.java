package mall.dictionary.service.domain;

import mall.core.domain.Repository;
import mall.core.domain.query.Criteria;

import java.util.Optional;

/**
 * @author Walter
 */
public interface DictionaryRepository extends Repository<Integer, Dictionary> {
    default Optional<Dictionary> findByCode(String code) {
        return findOne(Criteria.equalTo("code", code));
    }
}




