package com.hs2b.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lists")
@Getter @Setter
public class ListTest {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private String value;

}
