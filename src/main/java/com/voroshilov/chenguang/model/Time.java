package com.voroshilov.chenguang.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @SequenceGenerator(
            name = "time-seq-gen",
            sequenceName = "time_id_seq",
            allocationSize = 1
    )
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Pattern(regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$",
            message = "Time format must be HH:mm")
    private LocalTime startTime;

    @Pattern(regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$",
            message = "Time format must be HH:mm")
    private LocalTime finishTime;

}
