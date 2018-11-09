package com.niehziliang.authorization.code;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/31 下午3:49
 */
public class Application {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i =0 ; i < 5;i++) {
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"子线程开始");
                // 子线程休眠五秒
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"子线程结束");
            });
            thread.start();

            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}

