package com.glearning.twitterapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@ToString
@EqualsAndHashCode(exclude = {"name","age"})
@Table(name="twitter_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @Setter @Getter
    private String name;
    @Getter @Setter
    private int age;

    User(){}

    public User(String name){
        this.name = name;
    }
}
