package com.bo.coding.competition.week189;

public class B {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] split = text.split(" ");
        mergeSort(split,0,split.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                char[] chars = split[0].toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                sb.append(chars);
            } else {
                sb.append(" ");
                sb.append(split[i]);
            }

        }
        return sb.toString();
    }

    private void mergeSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(strs, left, mid);
        mergeSort(strs, mid + 1, right);
        merge(strs, left, mid, right);
    }

    private void merge(String[] arr, int left, int mid, int right) {
        int i = left,j = mid + 1, n = 0;
        String temp[] = new String[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i].length() > arr[j].length()) {
                temp[n++] = arr[j++];
            } else {
                temp[n++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[n++] = arr[i++];
        }
        while (j <= right) {
            temp[n++] = arr[j++];
        }
        for (int k = 0; k < n; k++) {
            arr[k + left] = temp[k];
        }
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.arrangeWords("To be or not to be"));
    }
}
