package ru.yande.practicum;

import java.util.Objects;

public class TimeOfDay implements  Comparable<TimeOfDay> {


    @Override
    public int compareTo(TimeOfDay other){
        if (this.getHours() != other.getHours()){
            return Integer.compare(this.getHours(), other.getHours());
        }
        return Integer.compare(this.getMinutes(), other.getMinutes());
    }
    //часы (от 0 до 23)
    private int hours;
    //минуты (от 0 до 59)
    private int minutes;

    public TimeOfDay(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    @Override
    public String toString() {
        return getHours() + " часов, " + getMinutes() + " минут";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        TimeOfDay that = (TimeOfDay) o;
        return hours == that.getHours()
                && minutes == that.getMinutes();

    }

    @Override
    public int hashCode(){
        return Objects.hash(hours,minutes);
    }
}