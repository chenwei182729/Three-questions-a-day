package edu.cninfo.basic.day03;

/**
 * @author chenxinwei
 * @date 2019/11/7 9:53
 **/
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Cooffee.CAPPUCCINO;
    }
}
