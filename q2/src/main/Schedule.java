package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule{
    static final String SOLUTION = "solution";
    static final String FAILURE = "failure";

    List<String> varables;
    Integer[] domain;

    private void init(){
//        varables = new ArrayList<>(
//                Arrays.asList("A","B","C","D","E","F","G","H"));
//        domain = new Integer[]{1,2,3,4};
        varables = new ArrayList<>(
                Arrays.asList("X","Y","Z"));
        domain = new Integer[]{1,2};
        buildTree(new Tree(null, null), varables, new ArrayList<>(), 0);
    }


    private Tree buildTree(Tree node, List<String> varibles, List<Integer> preValues, int depth){
        if(depth >= varibles.size() ){
            System.out.println(SOLUTION + "; depth:" + depth + "; size" + varibles.size());
            return null;
        }

        String var = varibles.get(depth);
        depth++;
        int varIndex = depth - 1;

        for(Integer value : domain) {
            System.out.print(var + " = " + value + " ");

            if(varIndex < preValues.size()) {
                preValues.set(varIndex, value);
            }else{
                preValues.add(value);
            }

            if(checkConditionsFail(preValues, depth)) {
                System.out.println(FAILURE + "  " + depth);
            }else{

                node.addChild(buildTree(new Tree(var, value), varibles, preValues, depth));
            }
        }

        return node;
    }

    private boolean checkConditionsFail(List<Integer> values, int index){
//        System.out.println("size = " + values.size()+ ";index = " + index);
        index--;
//        int a = 0;
//        int b = 1;
//        int c = 2;
//        int d = 3;
//        int e = 4;
//        int f = 5;
//        int g = 6;
//        int h = 7;

        int x=0;
        int y=1;
        int z=2;

        if(index >=1 && (values.get(x) == values.get(y))) {
            return true;
        }

        if(index >=2 && (values.get(y) == values.get(z))){
            return true;
        }

        return false;

//        return (index >=g && !(values.get(a) > values.get(g))) ||
//                (index >=h && !(values.get(a) <= values.get(h))) ||
//                (index >=f && !(Math.abs(values.get(f) - values.get(b)) == 1)) ||
//                (index >=h && !(values.get(g)< values.get(h))) ||
//                (index >=g && !(Math.abs(values.get(g)- values.get(c)) == 1)) ||
//                (index >=h && !((Math.abs(values.get(h) - values.get(c)) % 2) == 0)) ||
//                (index >=h && !(values.get(h) != values.get(d))) ||
//                (index >=g && !(values.get(d)> values.get(g))) ||
//                (index >=d && !(values.get(d)!= values.get(c))) ||
//                (index >=e && !(values.get(e)!= values.get(c))) ||
//                (index >=e && !(values.get(e)< (values.get(d)- 1))) ||
//                (index >=h && !(values.get(e)!= (values.get(h) - 2))) ||
//                (index >=g && !(values.get(g)!= values.get(f))) ||
//                (index >=h && !(values.get(h) != values.get(f))) ||
//                (index >=f && !(values.get(c) != values.get(f))) ||
//                (index >=f && !(values.get(d)!= values.get(f))) ||
//                (index >=f && !((Math.abs(values.get(e)- values.get(f)) % 2) == 1));
    }

    public static void main(String[] args){
        Schedule schedule = new Schedule();
        schedule.init();
    }
}
