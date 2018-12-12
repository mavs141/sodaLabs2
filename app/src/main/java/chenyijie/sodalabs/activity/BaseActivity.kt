package chenyijie.sodalabs.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.NonNull
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    lateinit var subscriptions: CompositeDisposable
    lateinit var viewModel: ViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        subscriptions = CompositeDisposable()
        viewModel = createViewModel()

    }

    @NonNull
    @LayoutRes
    abstract fun getLayoutId(): Int

    @NonNull
    abstract fun createViewModel(): ViewModel

    override fun onDestroy() {
        super.onDestroy()
        if (subscriptions.isDisposed) {
            subscriptions.dispose()
        }
    }
}