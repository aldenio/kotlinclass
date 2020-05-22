package _03_FP;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Pessoa {
    private String name;
    private String sobrenome;

    public Pessoa(String name) {
        this.name = name;
    }

    public void create(Created created){
        created.onCreate(this);
    }

    public @Nullable String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotNull String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }
}
