package b6;

import java.lang.management.*;

public class DeadlockDetector implements Runnable {

    public void run() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] ids = bean.findDeadlockedThreads();

        System.out.println("Đang quét deadlock...");

        if (ids == null) {
            System.out.println("Không phát hiện deadlock.");
            return;
        }

        ThreadInfo[] infos = bean.getThreadInfo(ids);

        System.out.println("Phát hiện deadlock:");

        for (ThreadInfo info : infos) {
            System.out.println(info.getThreadName());
        }
    }
}