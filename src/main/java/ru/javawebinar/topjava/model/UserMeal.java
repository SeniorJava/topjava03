package ru.javawebinar.topjava.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
@Entity
@Table(name = "MEALS")
@NamedQueries({
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId"),
        @NamedQuery(name = UserMeal.DELETE_ALL, query = "DELETE FROM UserMeal m WHERE m.user.id=:userId"),
        @NamedQuery(name = UserMeal.GET, query ="SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId" ),
        @NamedQuery(name = UserMeal.GET_BETWEEN, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId AND" +
                "  m.dateTime<:before AND m.dateTime>:after")
})
public class UserMeal extends BaseEntity{

    public static final String DELETE = "UserMeal.delete";
    public static final String GET = "UserMeal.get";
    public static final String ALL_SORTED = "UserMeal.allSorted";
    public static final String DELETE_ALL = "UserMeal.deleteAll";
    public static final String GET_BETWEEN = "UserMeal.getBetween";

    @Column(name = "time", columnDefinition = "timestamp default now()")
    protected LocalDateTime dateTime;

    @Column(name = "description")
    protected String description;

    @Column(name = "calories")
    protected int calories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public UserMeal() {
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal(" + id + ", " + dateTime + ", '" + description + "', calories:" + calories + ')';
    }
}
