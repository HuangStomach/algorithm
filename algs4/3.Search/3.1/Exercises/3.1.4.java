class Time implements Comparable<Time> {
    private String time;

    public Time(String time) {
        this.time = time;
    }

    public int compareTo(Time that) {
        return Integer.parseInt(this.time) - Integer.parseInt(that.time);
    }
}