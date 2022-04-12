package thread.task;

public interface CountDownListener {

    public void countDownEnd();

    public void countDownInfoNotice(long mm,long ss);

    //Last ten seconds
    public void countDownLastTenSeconds(long ss);
}
