package chapter2;

import java.util.Objects;

/**
 * P25 赋值运算符
 * 面试题1：赋值运算符函数
 * <p>
 * 题目要求：
 * 为自定义类添加赋值运算符函数，考察一些细节点的书写。
 * <p>
 * 细节1:空指针
 * 细节2:返回本身可以连续调用
 */
public class P25_AssignmentOperator {

    public static class AOClass {
        public int key;

        public AOClass() {
        }

        public AOClass(int key) {
            this.key = key;
        }


        public AOClass assign(AOClass aoClass) {
            if (aoClass == null) {
                return this;
            }
            if (this.equals(aoClass)) {
                return this;
            }
            this.key = aoClass.key;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AOClass aoClass = (AOClass) o;
            return key == aoClass.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "AOClass{" +
                    "key=" + key +
                    '}';
        }
    }
}
