import com.cn.pojo.Student;
import com.cn.pojo.UserTest;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n;
        ArrayList al=new ArrayList();
        System.out.println("请输入需要的个数");
        n=scan.nextInt();
        System.out.println("请逐一输入");
        for(int i=0;i<n;i++) {
            al.add(i,scan.nextInt());
        }
        System.out.println("你输入的数字是：");
        for(int i=0;i<al.size();i++) {
            int temp=(int)al.get(i);
            System.out.print(temp+" ");
        }
        Collections.sort(al);//针对一个ArrayList内部的数据排序
        System.out.println();
        System.out.println("经过排序后：");
        for(int i=0;i<al.size();i++) {
            int temp=(int)al.get(i);
            System.out.print(temp+" ");
        }
    }

}
