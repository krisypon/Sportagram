package android.arch.lifecycle;

public class ViewModelProvider
{
  private final Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(ViewModelStore paramViewModelStore, Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public <T extends ViewModel> T get(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
    localStringBuilder.append(str);
    return get(localStringBuilder.toString(), paramClass);
  }
  
  public <T extends ViewModel> T get(String paramString, Class<T> paramClass)
  {
    ViewModel localViewModel = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localViewModel)) {
      return localViewModel;
    }
    paramClass = this.mFactory.create(paramClass);
    this.mViewModelStore.put(paramString, paramClass);
    return paramClass;
  }
  
  public static abstract interface Factory
  {
    public abstract <T extends ViewModel> T create(Class<T> paramClass);
  }
}


