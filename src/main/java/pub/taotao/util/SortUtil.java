package pub.taotao.util;

import java.util.Collections;
import java.util.List;

public class SortUtil {
    /**
     * 冒泡排序
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>List<T> bubbleSort(List<T> list){
        T temp;
        int length = list.size();
        int i,j;
        for(j = length - 1;j > 0;j--) {
            for (i = 0; i < j; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) { //list[i-1]>list[i]
                    temp = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, temp);
                }
            }
        }

        return list;
    }

    /**
     * 选择排序
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>List<T> selectionSort(List<T> list){
        T temp;
        int i,j,min;
        for(i = 0;i < list.size(); i++) {
            min = i;
            for (j = i; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(min)) < 0) //list[j]<list[min]
                    min = j;
            }
            if(i != min) {
                temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }

        return list;
    }
    public static <T extends Comparable<? super T>>List<T> quickSort(List<T> list){
        return list;
    }
    public static <T extends Comparable<? super T>>List<T> insertionSort(List<T> list){
        return list;
    }
    public static <T extends Comparable<? super T>>List<T> mergeSort(List<T> list){
        return list;

    }
    public static <T extends Comparable<? super T>>List<T> heapSort(List<T> list){
        return list;
    }

    /**
     * 反转一个数组
     * @param list 需要反转的数组
     * @param <T> 数组元素泛型
     * @return 反转后的数组
     */
    public static <T>List<T> reverse(List<T> list){
        int halfLen = list.size() / 2;
        int length = list.size() - 1;
        T temp;
        for (int i = 0; i < halfLen; i++){
            temp = list.get(i);
            list.set(i,list.get(length - i));
            list.set(length - i,temp);
        }

        return list;
    }
}
