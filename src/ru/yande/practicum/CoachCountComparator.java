package ru.yande.practicum;

import java.util.Comparator;
import java.util.Map;

public class CoachCountComparator implements Comparator<Coach> {
    private final Map<Coach, Integer> counts;

    public CoachCountComparator(Map<Coach, Integer> counts){
        this.counts = counts;
    }

    @Override
    public int compare(Coach c1, Coach c2){
        return Integer.compare(counts.get(c2), counts.get(c1));
    }


}
