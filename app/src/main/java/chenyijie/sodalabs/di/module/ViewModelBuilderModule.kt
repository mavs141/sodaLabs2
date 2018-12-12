package chenyijie.sodalabs.di.module

import android.arch.lifecycle.ViewModelProvider
import chenyijie.sodalabs.di.MyViewModelProviderFactory
import chenyijie.voicetube.di.scope.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilderModule {
    @Binds
    @PerActivity
    abstract fun bindViewModelFactory(factory: MyViewModelProviderFactory): ViewModelProvider.Factory
}