package pkg;

import java.util.Arrays;

public class main {
    public String[] solution(String[] arr, int n) {
        String[] tempArr = new String[arr.length];
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; i < arr.length; j++) {
                if(arr[i].equals(arr[j])){
                    if(Arrays.asList(arr).contains(arr[i])) {
                        tempArr[i] = arr[i];
                        cnt++;
                    }
                }
            }
        }
        String[] answer = new String[cnt];
        for(int i = 0; i < answer.length-1; i++) {
            answer[i] = tempArr[i];
        }
        System.out.println(Arrays.toString(tempArr));
        return answer;
    }

    public static void main(String[] args) {
        main method = new main();
        String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
        int n = 2;
        System.out.println(Arrays.toString(method.solution(arr, n)));
    }
}