package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select g from Group g where g.name = :name")
    Group findByName(@Param("name") String name);

    @Query("select g from Group g join fetch g.childrenGroups where g.name = :name")
    Group findByNameFetchChildren(@Param("name") String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {
            "childrenGroups"//, "childrenGroups.childrenGroups", "childrenGroups.childrenGroups.childrenGroups",
            //"childrenGroups.childrenGroups.childrenGroups.childrenGroups",
            //"childrenGroups.childrenGroups.childrenGroups.childrenGroups.childrenGroups"
    })
    @Query("select g from Group g where g.name = :name")
    Group loadGroupWithChildrenByName(@Param("name") String name);
}
