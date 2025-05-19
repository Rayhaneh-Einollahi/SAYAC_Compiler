package main.symbolTable.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Key {
    private String type;
    private String name;
    private Integer argCount = 0;
//    private List<List<String>> params = new ArrayList<>();

    public Key(String type, String name, Integer argCount){
        this.type = type;
        this.name = name;
        this.argCount = argCount;
    }
    public Key(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key other)) return false;
        return Objects.equals(type,   other.type)
                && Objects.equals(name,   other.name)
                && Objects.equals(argCount, other.argCount);
//                && Objects.equals(params, other.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, argCount);
    }
}
