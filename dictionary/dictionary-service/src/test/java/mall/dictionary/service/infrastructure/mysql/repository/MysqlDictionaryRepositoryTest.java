package mall.dictionary.service.infrastructure.mysql.repository;

import mall.dictionary.service.domain.Dictionary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author walter
 */
@SpringBootTest
class MysqlDictionaryRepositoryTest {

    @Autowired
    private MysqlDictionaryRepository repository;

    @Test
    void save() {
    }

    @Test
    void getIfPresent() {
        Optional<Dictionary> dictionary = repository.getIfPresentByCode("order_type");
        dictionary.ifPresent(d -> repository.delete(d.getId()));
        Dictionary dict = new Dictionary();
        dict.setCode("order_type");
        dict.addItem("Retail Order", "RETAIL_ORDER");
        dict.addItem("Wholesale Order", "WHOLESALE_ORDER");
        repository.save(dict);
        assertTrue(repository.getIfPresent(dict.getId()).isPresent());
        assertFalse(repository.getIfPresent(10000).isPresent());
        repository.delete(dict.getId());
        assertFalse(repository.exist(dict.getId()));
    }

    @Test
    void delete() {
    }
}