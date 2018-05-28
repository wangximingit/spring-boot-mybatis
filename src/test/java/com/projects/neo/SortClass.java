package com.projects.neo;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * __
 * ,-~¨^  ^¨-,           _,
 * /          / ;^-._...,¨/
 * /          / /         /
 * /          / /         /
 * /          / /         /
 * /,.-:''-,_ / /         /
 * _,.-:--._ ^ ^:-._ __../
 * /^         / /¨:.._¨__.;
 * /          / /      ^  /
 * /          / /         /
 * /          / /         /
 * /_,.--:^-._/ /         /
 * ^            ^¨¨-.___.:^
 *
 * @author WangXiMin
 * @date 2018/5/14 17:28
 */
public class SortClass {

    public static void main(String[] args) {
        int[] arr = {12,2,3,1,5,67,97,33,21,11};
        cSort(arr);
//        arr = quickSort(arr,0,arr.length-1);
//        for (int i:arr){
//            System.out.println(i);
//        }
    }


    private static void xSort(int[] arr){
        for (int i:arr) {
            System.out.println(i);
        }
        int index;
        for (int i=0;i<arr.length-1;i++){
            index = i;
            for (int y=i+1;y<arr.length;y++){
                if(arr[y]<arr[index]){
                    index = y;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println("------------");
        for (int i:arr) {
            System.out.println(i);
        }
    }

    private static void cSort(int[] arr){
        for (int i:arr) {
            System.out.println(i);
        }

        int pre ;
        int current ;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{

        });

        for(int i=1;i<arr.length;i++){
            pre = i-1;
            current = arr[i];
            while (pre>=0 && arr[pre] > current){
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = current;
        }

        System.out.println("------------");
        for (int i:arr) {
            System.out.println(i);
        }
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        int partitionIndex;

        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {     // 分区操作
        int pivot = left,                      // 设定基准值（pivot）
                index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
