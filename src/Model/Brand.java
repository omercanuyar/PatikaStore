package Model;

import java.util.UUID;

public class Brand {
    private UUID id;
    private String name;
    public Brand(String name){
        this.id = UUID.randomUUID();
        this.name=name;
    }
}
