package chenyijie.sodalabs.di.module

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity
import chenyijie.sodalabs.activity.MainActivity
import chenyijie.sodalabs.viewmodel.MainActivityViewModel
import chenyijie.voicetube.di.scope.PerActivity
import chenyijie.voicetube.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [(ViewModelBuilderModule::class)])
abstract class MainActivityModule {
    @Binds
    @PerActivity
    abstract fun activity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}