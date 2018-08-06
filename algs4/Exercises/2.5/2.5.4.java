import java.util.ArrayList;

class Dedup {
    public static String[] dedup(String[] a) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            if (list.contains(a[i])) continue;
            list.add(a[i]);
        }
        
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        String[] strs = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        String[] array = dedup(strs);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}