package org.example.algorithmmonitor.src.application.domain;


import jakarta.annotation.PostConstruct;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProblemBox {

    // 탐색 기준 : type, result
    // -> 나중에 반정규화해놓기(분류해서 따로 저장)
    // -> MySQL 쓰면 index 걸기
    private final List<Problem> problems = new ArrayList<>();

    @PostConstruct
    private void setProblemBox() {
        //org.example.algorithmmonitor.src.problem 패키지 내 Problem 클래스들 탐색
        Reflections reflections = new Reflections("org.example.algorithmmonitor.src.problem");

        Set<Class<? extends Problem>> classes = reflections.getSubTypesOf(Problem.class)
                .stream()
                .filter(clazz -> !java.lang.reflect.Modifier.isAbstract(clazz.getModifiers()))
                .collect(Collectors.toSet());

        if (classes.isEmpty()) {
            System.out.println("No Problem classes found.");
        }

        for (Class<?> clazz : classes) {
            try {
                Problem problem = (Problem) clazz.getDeclaredConstructor().newInstance();
                //problem list 에 추가
                problems.add(problem);
                System.out.println("Added problem: " + problem.getClass().getSimpleName());
            } catch (Exception e) {
                System.out.println("Could not instantiate class: " + clazz.getName());
                e.printStackTrace();
            }
        }

        System.out.println("problems.size(): " + problems.size());
    }
}
