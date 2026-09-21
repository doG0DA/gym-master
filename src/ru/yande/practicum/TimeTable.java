package ru.yande.practicum;

import java.util.*;

public class TimeTable {

    private final Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable = new HashMap<>();

    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();

        timetable.computeIfAbsent(day, k -> new TreeMap<>())
                        .computeIfAbsent(time, k -> new ArrayList<>())
                                . add(trainingSession);

    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        TreeMap<TimeOfDay, List<TrainingSession>> daySchedule = timetable.get(dayOfWeek);
        if (daySchedule == null) {
            return new ArrayList<>();
        }
        List<TrainingSession> listOfTrainings = new ArrayList<>();
        for (List<TrainingSession> session : daySchedule.values()) {
            listOfTrainings.addAll(session);
        }
        return listOfTrainings;
    }


    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        TreeMap<TimeOfDay, List<TrainingSession>> schedule = timetable.get(dayOfWeek);
        if (schedule == null) {
            return new ArrayList<>();
        }
        List<TrainingSession> trainingSessions = schedule.get(timeOfDay);
        if (trainingSessions == null) {
            return new ArrayList<>();
        }

        return trainingSessions;

    }

    public TreeMap<Coach, Integer> getCountByCoaches() {
        Map<Coach, Integer> listOfTrainingsByCoach = new HashMap<>();

        for (TreeMap<TimeOfDay, List<TrainingSession>> grid : timetable.values()) {
            for (List<TrainingSession> listOfTrainings : grid.values()) {
                for (TrainingSession session : listOfTrainings) {
                    Coach coach = session.getCoach();
                    listOfTrainingsByCoach.put(coach, listOfTrainingsByCoach.getOrDefault(coach, 0) + 1);
                }
            }
        }

        TreeMap<Coach, Integer> sorted = new TreeMap<>(new CoachCountComparator(listOfTrainingsByCoach));
        sorted.putAll(listOfTrainingsByCoach);

        return sorted;
    }

}
