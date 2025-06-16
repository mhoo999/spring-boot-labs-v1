package com.example.myfirstspringbootapp.di_with_assembler.cafe;

public class PremiumCoffeeMachine implements CoffeeMachine {
    @Override
    public String brew() {
        return "고오급 커피 머신으로 커피를 내린다.";
    }
}
