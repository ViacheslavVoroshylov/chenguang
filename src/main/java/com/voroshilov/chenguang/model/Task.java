package com.voroshilov.chenguang.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator = "sequence-genetator")
    @SequenceGenerator(
            name = "task-seq-gen",
            sequenceName = "task_id_seq",
            allocationSize = 1
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

}
