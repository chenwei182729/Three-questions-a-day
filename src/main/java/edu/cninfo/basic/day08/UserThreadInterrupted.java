package edu.cninfo.basic.day08;


import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 通过thread.interrupt() 中断一个线程
 */
public class UserThreadInterrupted {

    public static void main(String[] args) {
        final FileSearch fileSearch = new FileSearch("C:\\", "autoexec.bat");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }

    static class FileSearch implements Runnable {
        private String initPath;
        private String findFile;

        public FileSearch(String initPath, String findFile) {
            this.initPath = initPath;
            this.findFile = findFile;
        }

        @Override
        public void run() {
            File file = new File(initPath);
            if (file.isDirectory()) {
                try {
                    processDirectory(file);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " : The search has bean interrupted");
                    cleanResource();
                }
            }
        }

        private void cleanResource() {
        }

        private void processDirectory(File file) throws InterruptedException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File f : listFiles) {
                    if (f.isDirectory()) {
                        processDirectory(f);
                    } else {
                        processFile(f);
                    }
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        private void processFile(File file) throws InterruptedException {
            if (file.getName().equals(findFile)) {
                System.out.println(Thread.currentThread() + " : " + file.getAbsoluteFile());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }
}
