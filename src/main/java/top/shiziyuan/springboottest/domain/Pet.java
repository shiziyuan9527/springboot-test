package top.shiziyuan.springboottest.domain;

import lombok.Data;

@Data
public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
