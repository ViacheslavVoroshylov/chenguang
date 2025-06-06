package com.voroshilov.chenguang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator = "sequence-genetator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "task_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column(nullable = false)
    @Size(max=255)
    private String name;

    @Size(max=255)
    private String description;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "time_id")
    private Time timeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTimeId(){
        return timeId;
    }

    public void setTimeId(Time timeId){
        this.timeId = timeId;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", description = " + description +
                "} ";
    }
}
