package Model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> properties = new ArrayList<>();

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }
}
