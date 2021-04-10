package EventBus;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class EventBusTest {

  public static void main(String[] args) throws InterruptedException {
    EventBus eventBus = new EventBus(new SubscriberExceptionHandler() {
      public void handleException(Throwable exception, SubscriberExceptionContext context) {
        System.out.println("hutool:" + ExceptionUtil.getRootCauseMessage(exception));
        System.out.println("guava:" + Throwables.getStackTraceAsString(exception));
        System.out.println("apache:" + ExceptionUtils.getRootCause(exception));
      }
    });
    eventBus.register(new WarnManagerHandler());
    eventBus.register(new SubscribeManager());
    eventBus.post(1);
    eventBus.post("2");
    eventBus.post(Lists.newArrayList("3","4"));

  }

}
