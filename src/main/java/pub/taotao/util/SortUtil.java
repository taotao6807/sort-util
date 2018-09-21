package pub.taotao.util;

import java.util.ArrayList;
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

    /**
     * 快速排序
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>List<T> quickSort(List<T> list) {
        return quickSort(list,0,list.size() - 1);
    }

    public static <T extends Comparable<? super T>>List<T> quickSort(List<T> list,int left,int right){
        if(left >= right) return list;

        int pivot = left;
        int i = left,j = right;
        T temp;
        while(i < j){
            while (list.get(j).compareTo(list.get(pivot)) > 0)//list[j] > list[pivot]
                j--;
            while (list.get(i).compareTo(list.get(pivot)) < 0)//list[i] < list[pivot]
                i++;
            //交换i和j的值
            if(i < j) {
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        //最终交换pivot和j的值，使得pivot处于中间
        temp = list.get(j);
        list.set(j, list.get(pivot));
        list.set(pivot, temp);

        quickSort(list,left,j - 1);
        quickSort(list,j + 1,right);
        return list;
    }

    /**
     * 插入排序
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>List<T> insertionSort(List<T> list){
        int length = list.size();
        int i,j;
        T temp;
        for(j = 1; j<length;j++){
            for(i = 0;i <= j;i++){
                //找到第一个比list[j]大的数，把list[j]插到这个数前面
                if(list.get(i).compareTo(list.get(j)) > 0){//list[i]>list[j]
                    temp = list.get(j);
                    for(int k = j;k > i;k--){
                        list.set(k,list.get(k-1));
                    }
                    list.set(i,temp);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 归并排序
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>List<T> mergeSort(List<T> list){
        return mergeSort(list,0,list.size()-1);
    }
    private static <T extends Comparable<? super T>>List<T> mergeSort(List<T> list,int begin,int end){
        if(begin < end) {
            int mid = (begin + end) >>> 1;
            mergeSort(list,begin,mid);
            mergeSort(list,mid + 1,end);
            merge(list,begin,mid,end);
        }
        return list;
    }

    private static <T extends Comparable<? super T>>void merge(List<T> list,int begin,int mid,int end){
        List<T> temp = new ArrayList<>();
        int i =begin,j=mid + 1;
        while(i<=mid&&j<=end){
            if(list.get(i).compareTo(list.get(j)) <= 0) {
                temp.add(list.get(i++));
            }else{
                temp.add(list.get(j++));
            }

        }
        while(i<=mid){//将左边剩余元素填充
            temp.add(list.get(i++));
        }
        while(j<=end){//将右序列剩余元素填充
            temp.add(list.get(j++));
        }

        for(T t:temp)
            list.set(begin++,t);
    }

    /**堆排序
     *
     * @param list
     * @param <T>
     * @return
     */
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
        int halfLen = list.size() >>> 1;
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
