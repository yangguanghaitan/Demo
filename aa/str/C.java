package str;

public class C {
    public String replaceSpace (String s) {
        // write code here
        int oldLength=s.length();
        int newLength=oldLength;
        for (int i = 0; i < oldLength; i++) {
            if (' '==s.charAt(i)){
                newLength+=2;
            }
        }
        char[] str=new char[newLength];
        int i = newLength;
        while (oldLength>=1){
            if (s.charAt(oldLength-1)==' '){
                str[--i]='0';
                str[--i]='2';
                str[--i]='%';
            }else {
                str[--i]=s.charAt(oldLength-1);
            }
            oldLength--;
        }
        String s2 = new String(str);
        return s2;
    }

    public static void main(String[] args) {
        C c=new C();
        String hello_world = c.replaceSpace("hello world");
        System.out.println(hello_world);
    }
}
