package EventBus;

import com.google.common.base.Throwables;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynEventBusTest {

  public static void main(String[] args) {
    final EventBus eventBus = new AsyncEventBus(Executors
        .newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("guava-pool-%d").build()),
        new SubscriberExceptionHandler() {
          public void handleException(Throwable exception, SubscriberExceptionContext context) {
            System.out.println(Throwables.getStackTraceAsString(exception));
          }
        });
    eventBus.register(new SubscribeManager());
    eventBus.register(new WarnManagerHandler());
    eventBus.post(21);
    eventBus.post(22);
    eventBus.post("23");
    final ExecutorService executorService = Executors.newFixedThreadPool(3);
    executorService.submit(new Runnable() {
      public void run() {
        for (int i = 0; i < 100; i++) {
          eventBus.post(1);
        }
      }
    });

  }
}
