package com.voroshilov.chenguang.model;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDateTime;

public class Time {

    @Id
    @GeneratedValue(generator = "sequence-genetator")
    @SequenceGenerator(
            name = "time-seq-gen",
            sequenceName = "time_id_seq",
            allocationSize = 1
    )
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
