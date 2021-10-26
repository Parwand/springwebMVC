package net.parwand.springmvc.entity;

import javax.validation.constraints.NotNull;

public record Sum(@NotNull int a, @NotNull int b){

    public int add(){
        return a+b;
    }
}
