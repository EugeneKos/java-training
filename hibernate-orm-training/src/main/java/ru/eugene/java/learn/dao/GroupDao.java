package ru.eugene.java.learn.dao;

import ru.eugene.java.learn.data.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;

@Component
public class GroupDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public GroupDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Group findByNameWithLoadChildren(String name, int loadDeep){
        if(loadDeep < 0){
            throw new IllegalArgumentException("load deep don't must be negative");
        }

        TypedQuery<Group> query = entityManager.createQuery("select g from Group g where g.name = :name", Group.class);
        query.setParameter("name", name);

        if(loadDeep >= 1){
            EntityGraph<Group> entityGraph = entityManager.createEntityGraph(Group.class);
            entityGraph.addAttributeNodes("childrenGroups");

            if(loadDeep > 1){
                Subgraph<Object> childrenGroups = entityGraph.addSubgraph("childrenGroups");
                for (int i = 1; i < loadDeep; i++) {
                    childrenGroups.addAttributeNodes("childrenGroups");
                    childrenGroups = childrenGroups.addSubgraph("childrenGroups");
                }
            }
            query.setHint(org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH.getKey(), entityGraph);
        }

        return query.getSingleResult();
    }

    // Получаю полное дерево за два запроса
    // Первый запрос на получение всех груп с детьми
    // Поскольку все произходит в одной транзакции берем обычным запросом группу по имени
    // и получаем ее со всеми детьми.
    @Transactional
    public Group getGroupTreeByParentName(String name){
        entityManager.createQuery("select distinct g from Group g left join fetch g.childrenGroups").getResultList();
        return entityManager.createQuery("select g from Group g where g.name = :name", Group.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
