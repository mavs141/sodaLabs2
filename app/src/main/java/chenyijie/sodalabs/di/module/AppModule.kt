package chenyijie.sodalabs.di.module

import android.content.Context
import chenyijie.sodalabs.MyApplication
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContent(app: MyApplication): WeakReference<Context> = WeakReference(app)
}