// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package projectx.sk.com.tripbook.dependencyinjection;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import projectx.sk.com.tripbook.create.CreateFragment;
import projectx.sk.com.tripbook.create.CreateFragment_MembersInjector;
import projectx.sk.com.tripbook.data.ListItemDao;
import projectx.sk.com.tripbook.data.ListItemDatabase;
import projectx.sk.com.tripbook.data.ListItemRepository;
import projectx.sk.com.tripbook.detail.DetailFragment;
import projectx.sk.com.tripbook.detail.DetailFragment_MembersInjector;
import projectx.sk.com.tripbook.list.ListFragment;
import projectx.sk.com.tripbook.list.ListFragment_MembersInjector;

public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Application> provideApplicationProvider;

  private Provider<ListItemDatabase> provideListItemDatabaseProvider;

  private Provider<ListItemDao> provideListItemDaoProvider;

  private Provider<ListItemRepository> provideListItemRepositoryProvider;

  private Provider<ViewModelProvider.Factory> provideViewModelFactoryProvider;

  private ApplicationModule applicationModule;

  private DaggerApplicationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideApplicationProvider =
        ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
    this.provideListItemDatabaseProvider =
        DoubleCheck.provider(
            RoomModule_ProvideListItemDatabaseFactory.create(
                builder.roomModule, provideApplicationProvider));
    this.provideListItemDaoProvider =
        DoubleCheck.provider(
            RoomModule_ProvideListItemDaoFactory.create(
                builder.roomModule, provideListItemDatabaseProvider));
    this.provideListItemRepositoryProvider =
        DoubleCheck.provider(
            RoomModule_ProvideListItemRepositoryFactory.create(
                builder.roomModule, provideListItemDaoProvider));
    this.provideViewModelFactoryProvider =
        DoubleCheck.provider(
            RoomModule_ProvideViewModelFactoryFactory.create(
                builder.roomModule, provideListItemRepositoryProvider));
    this.applicationModule = builder.applicationModule;
  }

  @Override
  public void inject(ListFragment listFragment) {
    injectListFragment(listFragment);
  }

  @Override
  public void inject(CreateFragment createFragment) {
    injectCreateFragment(createFragment);
  }

  @Override
  public void inject(DetailFragment detailFragment) {
    injectDetailFragment(detailFragment);
  }

  @Override
  public Application application() {
    return Preconditions.checkNotNull(
        applicationModule.provideApplication(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private ListFragment injectListFragment(ListFragment instance) {
    ListFragment_MembersInjector.injectViewModelFactory(
        instance, provideViewModelFactoryProvider.get());
    return instance;
  }

  private CreateFragment injectCreateFragment(CreateFragment instance) {
    CreateFragment_MembersInjector.injectViewModelFactory(
        instance, provideViewModelFactoryProvider.get());
    return instance;
  }

  private DetailFragment injectDetailFragment(DetailFragment instance) {
    DetailFragment_MembersInjector.injectViewModelFactory(
        instance, provideViewModelFactoryProvider.get());
    return instance;
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private RoomModule roomModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (roomModule == null) {
        throw new IllegalStateException(RoomModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder roomModule(RoomModule roomModule) {
      this.roomModule = Preconditions.checkNotNull(roomModule);
      return this;
    }
  }
}
