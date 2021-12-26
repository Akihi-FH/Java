package org.fh.test;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {

    }
}


class Solution {
    public static void time() {
        LocalDateTime start = LocalDateTime.now();
        while (true) {
            LocalDateTime end = LocalDateTime.now();
            Duration duration = Duration.between(start, end);

            if (duration.toMinutes() == 5) {
                start = end;
                System.out.println("当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }
        }
    }

    public static void main(String[] args) {
        time();
    }
}