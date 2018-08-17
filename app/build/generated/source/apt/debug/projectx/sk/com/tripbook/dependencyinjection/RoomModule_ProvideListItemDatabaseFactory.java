// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package projectx.sk.com.tripbook.dependencyinjection;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import projectx.sk.com.tripbook.data.ListItemDatabase;

public final class RoomModule_ProvideListItemDatabaseFactory implements Factory<ListItemDatabase> {
  private final RoomModule module;

  private final Provider<Application> applicationProvider;

  public RoomModule_ProvideListItemDatabaseFactory(
      RoomModule module, Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public ListItemDatabase get() {
    return Preconditions.checkNotNull(
        module.provideListItemDatabase(applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ListItemDatabase> create(
      RoomModule module, Provider<Application> applicationProvider) {
    return new RoomModule_ProvideListItemDatabaseFactory(module, applicationProvider);
  }

  public static ListItemDatabase proxyProvideListItemDatabase(
      RoomModule instance, Application application) {
    return instance.provideListItemDatabase(application);
  }
}