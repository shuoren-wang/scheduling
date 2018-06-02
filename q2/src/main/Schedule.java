package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule{
    private static final String SOLUTION = "solution";
    private static final String FAILURE = "failure";

    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;
    private int e = 4;
    private int f = 5;
    private int g = 6;
    private int h = 7;

    private List<String> varables;
    private Integer[] domain;

    private void init(){
        varables = new ArrayList<>(
                Arrays.asList("A","B","C","D","E","F","G","H"));
        domain = new Integer[]{1,2,3,4};
        buildTree(new Tree(null, null), varables, new ArrayList<>(), 0);
    }


    private Tree buildTree(Tree node, List<String> varibles, List<Integer> preValues, int depth){
        if(depth >= varibles.size() ){
            System.out.println(SOLUTION);
            return null;
        }

        String var = varibles.get(depth);

        for(Integer value : domain) {
            System.out.print(var + " = " + value + " ");

            if(depth < preValues.size()) {
                preValues.set(depth, value);
            }else{
                preValues.add(value);
            }

            if(checkConditionsFail(preValues, depth)) {
                System.out.println(FAILURE);
            }else{

                node.addChild(buildTree(new Tree(var, value), varibles, preValues, depth + 1));
            }
        }

        return node;
    }

    private boolean checkConditionsFail(List<Integer> values, int index){

        return (index >=g && !(values.get(a) > values.get(g))) ||
                (index >=h && !(values.get(a) <= values.get(h))) ||
                (index >=f && !(Math.abs(values.get(f) - values.get(b)) == 1)) ||
                (index >=h && !(values.get(g)< values.get(h))) ||
                (index >=g && !(Math.abs(values.get(g)- values.get(c)) == 1)) ||
                (index >=h && !((Math.abs(values.get(h) - values.get(c)) % 2) == 0)) ||
                (index >=h && !(values.get(h) != values.get(d))) ||
                (index >=g && !(values.get(d)> values.get(g))) ||
                (index >=d && !(values.get(d)!= values.get(c))) ||
                (index >=e && !(values.get(e)!= values.get(c))) ||
                (index >=e && !(values.get(e)< (values.get(d)- 1))) ||
                (index >=h && !(values.get(e)!= (values.get(h) - 2))) ||
                (index >=g && !(values.get(g)!= values.get(f))) ||
                (index >=h && !(values.get(h) != values.get(f))) ||
                (index >=f && !(values.get(c) != values.get(f))) ||
                (index >=f && !(values.get(d)!= values.get(f))) ||
                (index >=f && !((Math.abs(values.get(e)- values.get(f)) % 2) == 1));
    }

    public static void main(String[] args){
        Schedule schedule = new Schedule();
        schedule.init();
    }
}
