package top.shiziyuan.springboottest.domain;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private Pet pet;

    public User(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }
}
