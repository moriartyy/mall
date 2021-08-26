package mall.dictionary.service.domain;

import mall.core.domain.Repository;

/**
 * @author walter
 */
public interface DictionaryRepositoryBake extends Repository {
    Dictionary getByCode(String code);
}
