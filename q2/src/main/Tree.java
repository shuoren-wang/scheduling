package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree implements Iterable<Tree>{
    private String name;
    private Integer value;
    private List<Tree> subTrees;

    Tree(String name, Integer value) {
        this.name = name;
        this.value = value;
        this.subTrees = new ArrayList<>();
    }

    public void addChild(Tree childNode){
        subTrees.add(childNode);
    }


    @Override
    public Iterator<Tree> iterator() {
        return subTrees.iterator();
    }



}
