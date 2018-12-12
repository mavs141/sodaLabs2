package chenyijie.sodalabs.di.module

import chenyijie.sodalabs.activity.MainActivity
import chenyijie.voicetube.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun mainActivity(): MainActivity
}