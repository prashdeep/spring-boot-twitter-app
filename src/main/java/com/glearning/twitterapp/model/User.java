package com.glearning.twitterapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 60)
    @JsonIgnore
    private String encryptedPassword;

    @Column(nullable = false, length = 31)
    private String firstName;

    @Column(nullable = false, length = 63)
    private String lastName;

    @Column(length = 31)
    private String country;

    @Column(length = 31)
    private String region;

    @Column(length = 31)
    private String location;

    @Column(length = 63)
    private String postalAddress;

    @Column(length = 10)
    private String postalCode;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonIgnore
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date modified;

    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tweet> tweets;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="users_followers",
            joinColumns = @JoinColumn(name = "followers"),
            inverseJoinColumns = @JoinColumn(name = "following"))

    private Set<User> followers = new HashSet<>();


    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> following = new HashSet<>();

    public User(){

    }

    public User(String email, String encryptedPassword, String firstName, String lastName) {
        super();

        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;

        this.created = new Date();

    }

    public void addTweet(Tweet tweet){
        this.getTweets().add(tweet);
        tweet.setUser(this);
    }


    public void addFollower(User follower){
        follower.getFollowing().add(this);
        this.getFollowers().add(follower);
    }
}
