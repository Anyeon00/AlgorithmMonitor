package org.example.algorithmmonitor.src.application.domain;

import lombok.Getter;

@Getter
public abstract class Problem {
    public static final Boolean success = true;
    public static final Boolean fail = false;

    protected String type = "";
    //백준인 경우, 프로그래머스 문제인 경우는 나중에 생각하기
    protected String number = "";
    protected String name = "";
    protected Boolean result = false;
    //    protected String memo = "";

    protected Problem() {
        number = this.getClass().getSimpleName();
    }

/*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        if (type == null) {
//            throw RuntimeException()
//        }
        return "Problem{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
*/
}
