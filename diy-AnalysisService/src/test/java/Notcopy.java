import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Notcopy {

    public static void main(String[] args) {
        List<String> beforeList = new ArrayList<String>();

        beforeList.add("sun");
        beforeList.add("star");
        beforeList.add("moon");
        beforeList.add("earth");
        beforeList.add("sun");
        beforeList.add("earth");

        Set<String> middleHashSet = new HashSet<String>(beforeList);

        List<String> afterHashSetList = new ArrayList<String>(middleHashSet);

        System.out.println(beforeList);
        System.out.println(afterHashSetList);
    }


}
