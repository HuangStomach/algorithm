import java.util.LinkedList;

class NatureMergeLinkedList {
    public static String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        
        while (true) {
            int high = -1, mid = -1;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) continue;
                else if (mid == -1 && list.get(i - 1).compareTo(list.get(i)) > 0 && i > 0) mid = i - 1;
                else if (mid > -1 && high == -1 && list.get(i - 1).compareTo(list.get(i)) > 0) {
                    high = i - 1;
                    merge(list, 0, mid, high);
                    break;
                }
            }
            if (high == -1 && mid == -1) break;
            if (high == -1) {
                merge(list, 0, mid, list.size() - 1);
                break;
            }
        }

        for (String str:list) {
            System.out.print(str);
        }
        System.out.println();
    }

    public static void merge(LinkedList<String> list, int low, int mid, int high) {
        while (high >= 0) {
            if (low > mid) {
                String str = list.remove(mid + 1);
                list.add(str);
            }
            else if (mid + 1 > high) {
                String str = list.remove(low);
                list.add(str);
                mid--;
            }
            else if (list.get(mid + 1).compareTo(list.get(low)) < 0) {
                String str = list.remove(mid + 1);
                list.add(str);
            }
            else {
                String str = list.remove(low);
                list.add(str);
                mid--;
            }
            high--;
        }
    }
}