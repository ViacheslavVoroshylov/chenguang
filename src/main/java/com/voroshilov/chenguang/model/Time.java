package com.voroshilov.chenguang.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
