package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);
    public static final  UserMeal us1 = new UserMeal(100000, LocalDateTime.parse("1994-11-27"),"бутербродик с черной икрой",150);
    public static final  UserMeal us2 = new UserMeal(100000, LocalDateTime.parse("1994-11-28"),"лапша мивина",300);
    public static final  UserMeal us3 = new UserMeal(100001, LocalDateTime.parse("1994-11-28"),"что такое еда?",0);

}
