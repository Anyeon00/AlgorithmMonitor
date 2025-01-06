package org.example.algorithmmonitor.src.application.domain;


import jakarta.annotation.PostConstruct;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProblemBox {

    // 탐색 기준 : type, result
    // -> 나중에 반정규화해놓기(분류해서 따로 저장)
    // -> MySQL 쓰면 index 걸기
    private final List<Problem> problems = new ArrayList<>();
    private HashMap<String, Problem> mapByType;

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

    public Integer size() {
        return problems.size();
    }

    public Boolean isEmpty() {
        return problems.isEmpty();
    }

    public Boolean isNotEmpty() {
        return !problems.isEmpty();
    }

    public Boolean contains(Object o) {
        return problems.contains(o);
    }

    public List<Problem> findByType(String type) {
        return problems.stream().filter(p -> p.getType().equals(type)).toList();
    }


    public List<Problem> getSolved() {
        return problems.stream().filter(p -> p.getResult() == Problem.success).toList();
    }

    public List<Problem> getUnsolved() {
        return problems.stream().filter(p -> p.getResult() == Problem.fail).toList();
    }

    public HashMap<String, Problem> getMapByType() {
        if (mapByType == null) {
            mapByType = new HashMap<>();
            //type 추출
            List<String> typeList = problems.stream().map(Problem::getType).toList();
            //type 별로 수행
            for (String type : typeList) {
                //해당 type에 해당하는 모든 problem을 찾아서, map에 put
                this.findByType(type).stream().forEach(p -> mapByType.put(type, p));
            }
        }
        return mapByType;
    }

    public HashMap<String, Problem> getSolvedMapByType() {
        HashMap<String, Problem> solvedMap = new HashMap<>();
        List<String> typeList = this.getSolved().stream().map(Problem::getType).toList();
        for (String type : typeList) {
            this.findByType(type).stream().forEach(p -> mapByType.put(type, p));
        }
        return solvedMap;
    }

    public HashMap<String, Problem> getUnsolvedMapByType() {
        HashMap<String, Problem> unsolvedMap = new HashMap<>();
        List<String> typeList = this.getUnsolved().stream().map(Problem::getType).toList();
        for (String type : typeList) {
            this.findByType(type).stream().forEach(p -> mapByType.put(type, p));
        }
        return unsolvedMap;
    }

}
