import java.util.*;

public class TransformString {
    public String trans(String s, int n) {
        // write code here
        char[] chs = s.toCharArray();
        int len = chs.length;
        //step 1
        swap(chs, 0, len-1);
        int start = 0;

        //step 2
        for(int i=0; i<len; i++) {
            if(chs[i] == ' ') {
                swap(chs, start, i-1);
                start = i+1;
            }
        }
        if(chs[len-1] != ' ') {
            swap(chs, start, len-1);
        }

        for(int i=0; i<len; i++) {
            if(chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] = (char)(chs[i]-'A'+'a');
            } else if(chs[i] >= 'a' && chs[i] <= 'z') {
                chs[i] = (char)(chs[i]-'a'+'A');
            }
        }
        String ans = new String(chs);
        return ans;
    }

    private static void swap(char[] chs, int start, int end) {
        int mid = (end - start) / 2;
        for(int i=0; i<mid; i++) {
            char tmp = chs[start+i];
            chs[start+i] = chs[end-i];
            chs[end-i] = tmp;
        }
    }

    public static void main(String[] args) {
        TransformString transformString = new TransformString();
        System.out.println(transformString.trans("Hello World", 16));
    }
}