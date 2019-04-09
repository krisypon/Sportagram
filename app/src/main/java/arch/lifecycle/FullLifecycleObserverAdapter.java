package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver mObserver;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.mObserver = paramFullLifecycleObserver;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    switch (paramEvent)
    {
    default: 
      return;
    case ???: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case ???: 
      this.mObserver.onDestroy(paramLifecycleOwner);
      return;
    case ???: 
      this.mObserver.onStop(paramLifecycleOwner);
      return;
    case ???: 
      this.mObserver.onPause(paramLifecycleOwner);
      return;
    case ???: 
      this.mObserver.onResume(paramLifecycleOwner);
      return;
    case ???: 
      this.mObserver.onStart(paramLifecycleOwner);
      return;
    }
    this.mObserver.onCreate(paramLifecycleOwner);
  }
}


