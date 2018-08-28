package chapter2;

/**
 * P25 赋值运算符
 * 面试题2：实现SingleTon模式
 * <p>
 * 1.懒加载
 * 2.线程同步
 * 3.反射调用？(通过在构造方法内)
 * 4.序列化和 反clone 。都是事先接口的方法。然后返回非法
 */
public class P32_SingleTonClass {
    public static void main(String[] args) {

    }

    /**
     * 静态内容类的方式
     * 利用jvm只加载一次class文件的方式，来保持线程同步和懒加载
     */
    final static class SingleTon1 {
        public static boolean isConstruct = false;

        private SingleTon1() {
            //通过静态的标志位，进行反射的保护，如果已经有实例了，就爆异常
            if (!isConstruct) {
                isConstruct = true;
            } else {
                throw new RuntimeException("this instance is Singleton!!");
            }
        }

        public static SingleTon1 getInstance() {
            return SingleTonHolder.SingleTon;
        }

        private final static class SingleTonHolder {
            private final static SingleTon1 SingleTon = new SingleTon1();
        }
    }

    /**
     * 利用synchronized锁的方式。通过volatile关键字保持单例及时刷出来。防止jvm的指令优化。（初始化，分配内存，创建对象）
     * 第一次null是为了提高效率，有直接返回
     * 第二次null是为了保证返回的是单例。
     * 利用jvm只加载一次class文件的方式，来保持线程同步和懒加载
     */
    final static class SingleTon2 {
        private static volatile SingleTon2 singleTon2;

        private SingleTon2() {
            if (singleTon2!=null) {
                throw new RuntimeException("this instance is Singleton!!");
            }
        }

        public static SingleTon2 getInstance() {
            if (singleTon2 == null) {
                synchronized (SingleTon2.class) {
                    if (singleTon2 == null) {
                        singleTon2 = new SingleTon2();
                    }
                }
            }
            return singleTon2;
        }
    }
}
