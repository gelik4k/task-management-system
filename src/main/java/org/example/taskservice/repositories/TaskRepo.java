package org.example.taskservice.repositories;

import org.example.taskservice.domain.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TaskRepo extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    List<Task> findByAuthorId(long id);

    List<Task> findByPerformerId(long id);

    @Query(
            value = "select * from entities.task",
            nativeQuery = true)
    List<Task> findAllTask();
}
