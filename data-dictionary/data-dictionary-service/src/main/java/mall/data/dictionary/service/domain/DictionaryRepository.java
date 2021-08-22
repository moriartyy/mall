package mall.data.dictionary.service.domain;

import mall.core.domain.Repository;

/**
 * @author walter
 */
public interface DictionaryRepository extends Repository {
    Dictionary getByCode(String code);
}
