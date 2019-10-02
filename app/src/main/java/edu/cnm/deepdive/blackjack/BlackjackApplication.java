package edu.cnm.deepdive.blackjack;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.blackjack.service.BlackjackDatabase;

public class BlackjackApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this); // Stetho lib opens a window to look inside app
    BlackjackDatabase.setApplicationContext(this); // "this" is the application context.
    final BlackjackDatabase database = BlackjackDatabase.getInstance();
    new Thread(new Runnable() {  // an anonymous class. Defines class in runnable.
      @Override
      public void run() {
        database.getShoeDao().delete();

      }
    }).start();
  }
}
