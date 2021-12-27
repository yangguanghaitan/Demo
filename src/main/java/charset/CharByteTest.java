package charset;//package string;

public class CharByteTest {

    public static void main(String[] args) throws Exception {
        // 第二个字符为BMP之外的字符，csdn编辑器无法显示该字符，可以在运行结果截图中看到
        String[] strArr = {"中", "��", "a", "aa"};
        String[] charsetArr = {"gbk", "utf-8", "utf-16", "gb2312","Unicode"};
        for(String str : strArr) {
            System.out.println(str);
            for(String charset : charsetArr) {
                byteTest(str, charset);
            }
            System.out.println("============================");
        }
    }

    public static void byteTest(String str, String charset) throws Exception {
        System.out.println("编码：" + charset
                + "\t所占字节数：" + str.getBytes(charset).length);
    }

}
