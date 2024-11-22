package org.example.taskservice.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.taskservice.domain.enums.TaskPriority;
import org.example.taskservice.domain.enums.TaskStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Entity
@Table(schema = "entities", name = "task")
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority")
    private TaskPriority taskPriority;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Person author;

    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Person performer;

    @OneToMany(mappedBy = "task", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Person getPerformer() {
        return performer;
    }

    public void setPerformer(Person performer) {
        this.performer = performer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void copy(Task task) {
        Optional.of(task.id).ifPresent(this::setId);
        Optional.of(task.header).ifPresent(this::setHeader);
        Optional.of(task.description).ifPresent(this::setDescription);
        Optional.of(task.taskStatus).ifPresent(this::setTaskStatus);
        Optional.of(task.taskPriority).ifPresent(this::setTaskPriority);
        Optional.of(task.author).ifPresent(this::setAuthor);
        Optional.of(task.performer).ifPresent(this::setPerformer);
        Optional.of(task.comments).ifPresent(this::setComments);
        Optional.of(task.creationDate).ifPresent(this::setCreationDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskPriority=" + taskPriority +
                ", author=" + author +
                ", performer=" + performer +
                ", comments=" + comments +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(header, task.header) && Objects.equals(description, task.description) && taskStatus == task.taskStatus && taskPriority == task.taskPriority && Objects.equals(creationDate, task.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, description, taskStatus, taskPriority, creationDate);
    }
}
