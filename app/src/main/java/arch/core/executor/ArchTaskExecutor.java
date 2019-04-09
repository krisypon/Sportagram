package android.arch.core.executor;

import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo
public class ArchTaskExecutor
  extends TaskExecutor
{
  private static final Executor sIOThreadExecutor = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      ArchTaskExecutor.getInstance().executeOnDiskIO(paramAnonymousRunnable);
    }
  };
  private static volatile ArchTaskExecutor sInstance;
  private static final Executor sMainThreadExecutor = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      ArchTaskExecutor.getInstance().postToMainThread(paramAnonymousRunnable);
    }
  };
  private TaskExecutor mDefaultTaskExecutor = new DefaultTaskExecutor();
  private TaskExecutor mDelegate = this.mDefaultTaskExecutor;
  
  public static ArchTaskExecutor getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null) {
        sInstance = new ArchTaskExecutor();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.mDelegate.executeOnDiskIO(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    return this.mDelegate.isMainThread();
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    this.mDelegate.postToMainThread(paramRunnable);
  }
}


