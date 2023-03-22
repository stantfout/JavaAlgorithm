package com.bo.coding.annotation;

import com.bo.coding.consts.StatusEnum;

import java.lang.annotation.*;

/**
 * 题目类型
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Question {
    /**
     * @return 题目类型
     */
    String[] type() default {};

    /**
     * @return 题目状态
     */
    StatusEnum status() default StatusEnum.ACCEPTED;
}
