import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Week5CRT {
    private static class Tuple<T1, T2> {
        public T1 a;
        public T2 b;
        public Tuple(T1 a, T2 b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class CentralReferencingTable {
        private LinkedHashMap<String, Tuple<Integer, String>> crt;
        private Stack<Tuple<String, String>> hiddenStack;

        public CentralReferencingTable(Map<String, List<String>> names) {
            crt = new LinkedHashMap<>();
            hiddenStack = new Stack<>();
            for(List<String> vars : names.values()) {
                for(String var : vars) {
                    crt.put(var, new Tuple<Integer, String>(0, ""));
                }
            }
        }

        public void display() {
            StringBuffer sb = new StringBuffer("CRT\n");
            for(String v : crt.keySet()) {
                sb.append(v);
                sb.append("\t");
                Tuple<Integer, String> e = crt.get(v);
                sb.append(e.a);
                sb.append("\t");
                sb.append(e.b);
                sb.append("\n");
            }
            sb.append("Hidden Stack\n");
            //To print the stack top to bottom.
            List<Tuple<String, String>> list = new ArrayList<>(hiddenStack);
            Collections.reverse(list);
            list.forEach(e -> {
                sb.append(e.a);
                sb.append("\t");
                sb.append(e.b);
                sb.append("\n");
            });
            System.out.println(sb.toString());
        }

        public void blockEnter(String block, Map<String, List<String>> names) {
            /*
             * Process entering a block with crt and hiddenStack.
             * Declared names should be activated properly.
             * Use Tuple with proper type arguments for entries of crt and hiddenStack.
             */
            List<String> var = names.get(block);

            for(String v : var)
            {
                if(crt.get(v).a == 1)
                {
                    Tuple<String, String> n = new Tuple(v, crt.get(v).b);
                    hiddenStack.push(n);
                }
            }

            int i = 0;
            for(String v : var)
            {
                i++;
                Tuple<Integer, String> t = new Tuple(1, block+i);
                crt.replace(v, t);
            }
            display();
        }

        public void blockExit(String block, Map<String, List<String>> names) {
            /*
             * Handling block exit with crt and hiddenStack.
             * Declared names should be deactivated properly.
             */
            List<String> var = names.get(block);

            for(String v : var)
            {
                Tuple<Integer, String> t = new Tuple(0, crt.get(v).b);
                crt.replace(v, t);
            }
            
            while(hiddenStack.isEmpty()==false)
            {
                Tuple<String, String> n = hiddenStack.pop();
                Tuple<Integer, String> t = new Tuple(1, n.b);
                crt.replace(n.a, t);
            }

        }
    }

    public static void main(String[] args) {
        //Initialize names for static information.
        Map<String, List<String>> names = new HashMap<>();
        names.put("A", Arrays.asList("x", "y"));
        names.put("B", Arrays.asList("x", "v"));
        names.put("C", Arrays.asList("w", "y"));
        names.put("D", Arrays.asList("w"));

        CentralReferencingTable crt = new CentralReferencingTable(names);
        //Call sequence.
        crt.blockEnter("A", names);
        crt.blockEnter("B", names);
        crt.blockExit("B", names);
        crt.blockEnter("C", names);
        crt.blockEnter("D", names);
        crt.blockExit("D", names);
        crt.blockExit("C", names);
        crt.blockExit("A", names);
        crt.display();
    }
}
