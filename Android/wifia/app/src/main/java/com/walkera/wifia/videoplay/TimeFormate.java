package com.walkera.wifia.videoplay;

public class TimeFormate {
    private int milliseconds;

    public TimeFormate(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public String formatetime() {
        String hour = String.valueOf(this.milliseconds / 3600000);
        String minute = String.valueOf((this.milliseconds % 3600000) / 60000);
        String second = String.valueOf(((this.milliseconds % 3600000) % 60000) / 1000);
        hour = deal(hour);
        minute = deal(minute);
        return new StringBuilder(String.valueOf(hour)).append(":").append(minute).append(":").append(deal(second)).toString();
    }

    private String deal(String time) {
        if (time.length() != 1) {
            return time;
        }
        if (time.equals("0")) {
            return "00";
        }
        return "0" + time;
    }

    public String toTime() {
        this.milliseconds /= 1000;
        int minute = this.milliseconds / 60;
        int second = this.milliseconds % 60;
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(minute % 60), Integer.valueOf(second)});
    }
}
