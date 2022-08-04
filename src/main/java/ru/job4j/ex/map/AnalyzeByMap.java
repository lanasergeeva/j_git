package ru.job4j.ex.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double avg = 0;
        int index = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                avg += subject.score();
                index++;
            }
        }
        return avg / index;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double avg = 0;
            int index = 0;
            for (Subject subject : pupil.subjects()) {
                avg += subject.score();
                index++;
            }
            rsl.add(new Label(pupil.name(), avg / index));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        double count = getSubjectsInts(pupils, temp);
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() / count));
        }
        return rsl;
    }

    private static int getSubjectsInts(List<Pupil> pupils, Map<String, Integer> temp) {
        int count = 0;
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                Integer integer = temp.get(subject.name());
                if (integer == null) {
                    temp.put(subject.name(), subject.score());
                } else {
                    temp.put(subject.name(), integer + subject.score());
                }
            }
        }
        return count;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double avg = 0;
            for (Subject subject : pupil.subjects()) {
                avg += subject.score();
            }
            rsl.add(new Label(pupil.name(), avg));
        }
        rsl.sort(Label::compareTo);
        return rsl.isEmpty() ? null : rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        getSubjectsInts(pupils, temp);
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
        }
        rsl.sort(Label::compareTo);
        return rsl.isEmpty() ? null : rsl.get(rsl.size() - 1);
    }
}
