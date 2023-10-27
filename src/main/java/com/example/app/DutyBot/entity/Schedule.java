package com.example.app.DutyBot.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {
    public long id;
    //TODO Сделать нормальное название
    public String dutyDate;

}
