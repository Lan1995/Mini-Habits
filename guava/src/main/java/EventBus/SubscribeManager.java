package EventBus;

import com.google.common.eventbus.Subscribe;

public class SubscribeManager {

  public  static String msg = "thread-id:%s,thread-name:%s";

  public static String getThreadInfo() {
    return String
        .format(msg, Thread.currentThread().getId(), Thread.currentThread().getName());
  }

  @Subscribe
  private void subscribeInteger(Integer num) {
    String threadInfo = getThreadInfo();
    System.out.println(threadInfo + "-----" + "int receive:" + num);
  }

  @Subscribe
  private void subscribeString(String num) {
    System.out.println(getThreadInfo() + "--------" + "string receive" + num);
  }

  @Subscribe
  private void subscribtInteger2(Integer num) {
    System.out.println(getThreadInfo() + "--------" + "int2 reveice" + num);
  }
}
