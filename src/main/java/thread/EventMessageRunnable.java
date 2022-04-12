package thread;

public class EventMessageRunnable implements Runnable  {
    /*** 是否继续运行 */
    private boolean runEnable;
    @Override
    public void run() {
        runEnable = true;//new Thread.start()后重新运转

        while (runEnable) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("EventMessageRunnable id="+Thread.currentThread().getId()+" name="+Thread.currentThread().getName());
        }
    }

    public void stopRunnable() {
        runEnable = false;
    }
}
