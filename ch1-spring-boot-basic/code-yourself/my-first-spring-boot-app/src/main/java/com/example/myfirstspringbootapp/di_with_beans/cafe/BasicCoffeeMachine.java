package com.example.myfirstspringbootapp.di_with_beans.cafe;

public class BasicCoffeeMachine implements CoffeeMachine {
    @Override
    public String brew() {
        return "일반 커피 머신으로 커피를 내린다.";
    }
}
