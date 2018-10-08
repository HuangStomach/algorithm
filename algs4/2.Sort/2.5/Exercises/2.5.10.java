class Version implements Comparable<Version> {
    private String number;

    Version(String number) {
        this.number = number;
    }

    public int compareTo(Version that) {
        String[] a = this.number.split("\\.");
        String[] b = that.number.split("\\.");

        for (int i = 0; i < a.length; i++) {
            int m = Integer.parseInt(a[i]);
            int n = Integer.parseInt(b[i]);
            int o = m - n;
            if (o < 0) return -1;
            else if (o > 0) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Version a = new Version("115.1.1");
        Version b = new Version("115.10.1");
        System.out.println(a.compareTo(b));
    }
}
