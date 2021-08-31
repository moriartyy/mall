package mall.dictionary.service.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author walter
 */
@Entity
@Table(name = "dictionary_item", schema = "dictionary", catalog = "")
public class DictionaryItemEntity {
    private Integer id;
    private String name;
    private String value;
    private Short order;
    private String link;
    private DictionaryEntity dictionary;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 45)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "order", nullable = false)
    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 500)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryItemEntity that = (DictionaryItemEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(value, that.value) && Objects.equals(order, that.order) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, order, link);
    }

    @ManyToOne
    @JoinColumn(name = "dictionary_code", referencedColumnName = "code", nullable = false)
    public DictionaryEntity getDictionary() {
        return dictionary;
    }

    public void setDictionary(DictionaryEntity dictionary) {
        this.dictionary = dictionary;
    }
}
