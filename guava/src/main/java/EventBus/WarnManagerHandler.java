package EventBus;

import static EventBus.SubscribeManager.getThreadInfo;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import java.util.List;


public class WarnManagerHandler {

  static int count = 0;

  @Subscribe
  void sendWarn(List<String> warn) {
    System.out.println(getThreadInfo() + "----" + JSONUtil.toJsonStr(warn));
  }

  @Subscribe
  @AllowConcurrentEvents
  void testOrder(Integer num) {
    System.out.println(getThreadInfo() + "------" + num + "WarnManagerHandler");
    for (int i = 0; i < 100; i++) {
      count++;
    }
    System.out.println("count" + count);
  }

  @Subscribe
  private void testThrow(Integer error) {
    throw new RuntimeException();
  }
}
