package pub.taotao;

import pub.taotao.util.SortUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i =0; i < 10; i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        System.out.println(SortUtil.reverse(list));
        SortUtil.mergeSort(list);
        System.out.println(list);
    }
}
