package chenyijie.sodalabs.di.component

import chenyijie.sodalabs.MyApplication
import chenyijie.sodalabs.di.module.ActivityBuildersModule
import chenyijie.sodalabs.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AndroidSupportInjectionModule::class), (ActivityBuildersModule::class)])
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}