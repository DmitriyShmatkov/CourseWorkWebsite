package com.coursework.freelance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Pattern(regexp = "([A-z0-9_.,\\-\\s]*|[А-я0-9_.,\\-\\s]*)",message = "Название указано некорректно")
    private String title;

    @NotBlank
    @Pattern(regexp = "([A-z0-9_.,\\-\\s]*|[А-я0-9_.,\\-\\s]*)", message = "Специальность указана некорректно")
    private String speciality;

    @NotBlank(message = "Описание не должно быть пустым")
    private String description;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getFormattedDate() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date);
    }

    public String getFormattedTime() {
        return DateTimeFormatter.ofPattern("HH:mm").format(time);
    }
}
