package top.shiziyuan.springboottest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private String age;
    private Pet pet;
    private List<String> friendNames;
    private List<Pet> pets;
    private Map<String, List<Pet>> petMap;
}
