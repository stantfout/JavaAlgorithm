package com.bo.coding.leetcode.leetcode301_400;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.Pair;
import com.bo.coding.consts.TypeConst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GoodQuestion
@Question(type = {TypeConst.DISJOINT_SET_DATA_STRUCTURE})
public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> parents = new HashMap<>();
        double[] res = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(1);
            if (!parents.containsKey(first)) {
                parents.put(first,new Pair<>(first,1.0));
            }
            if (!parents.containsKey(second)) {
                parents.put(second,new Pair<>(second,1.0));
            }
            union(first,second,values[i],parents);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);
            if (!parents.containsKey(first) || !parents.containsKey(second)) {
                res[i] = -1.0;
                continue;
            }
            Pair<String, Double> firstPair = find(first, parents);
            Pair<String, Double> secondPair = find(second, parents);
            if (!firstPair.getKey().equals(secondPair.getKey())) {
                res[i] = -1.0;
            } else {
                res[i] = secondPair.getValue() / firstPair.getValue();
            }
        }

        return res;
    }

    //(first / second = value)
    private void union(String first, String second, double value, Map<String, Pair<String, Double>> parents) {
        Pair<String, Double> firstPair= find(first, parents);//(firstParent / first = firstValue)
        Pair<String, Double> secondPair = find(second, parents);//(secondPair / second = secondValue)
        // (firstParent)
        //      /
        // (secondPair)
        //      =
        // (value * firstValue / secondValue)
        parents.put(secondPair.getKey(),new Pair<>(firstPair.getKey(), firstPair.getValue() * value / secondPair.getValue()));
    }

    // (a/b=5) (b/c=2) [(a/d=3) / (a/c=10)] = (c/d=3/10)
    private Pair<String,Double> find(String son, Map<String, Pair<String, Double>> parents) {
        Pair<String, Double> parent = parents.get(son);
        if (son.equals(parent.getKey())) {
            return parent;
        }
        Pair<String, Double> pParent = find(parent.getKey(), parents);
        parent = new Pair<>(pParent.getKey(),parent.getValue() * pParent.getValue());
        return parent;
    }
}
