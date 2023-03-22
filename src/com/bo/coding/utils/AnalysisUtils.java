package com.bo.coding.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;


public class AnalysisUtils {
    
    public static void main(String[] args) {
        searchGoodQuestionByType(TypeConst.DISJOINT_SET_DATA_STRUCTURE, TypeConst.STRING);
    }

    /**
     * 根据类型搜索好题
     * @param types 题目类型
     */
    public static void searchGoodQuestionByType(String... types) {
        Map<String, List<String>> res = new HashMap<>();
        Set<Class<?>> result = AnnotationUtils.getClassByAnnotation(GoodQuestion.class);
        for (Class<?> classs : result) {
            Question question =  classs.getAnnotation(Question.class);
            if (question != null) {
                String[] questionTypes = question.type();
                for (int i = 0; i < types.length; i++) {
                    String type = types[i];
                    if (Arrays.asList(questionTypes).contains(type)) {
                        List<String> list = res.getOrDefault(type, new ArrayList<>());
                        list.add(classs.getSimpleName());
                        res.put(type, list);
                    }
                }
            }
        }
        System.out.println(res);
    }
}
