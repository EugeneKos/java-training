package ru.eugene.java.learn.data;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "module",
        uniqueConstraints = {@UniqueConstraint(name = "module_name_uk", columnNames = "name")},
        indexes = {@Index(name = "module_name_ix", columnList = "name")})
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @CollectionTable(name = "module_alias",
            joinColumns = {@JoinColumn(name = "module_id",
                    foreignKey = @ForeignKey(name = "module_alias_fk"))})
    private List<String> aliases;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @CollectionTable(name = "module_params",
            joinColumns = {@JoinColumn(name = "module_id",
                    foreignKey = @ForeignKey(name = "module_params_fk"))})
    @MapKeyColumn(name = "key")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "value")
    private Map<Param, String> params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public Map<Param, String> getParams() {
        return params;
    }

    public void setParams(Map<Param, String> params) {
        this.params = params;
    }
}
