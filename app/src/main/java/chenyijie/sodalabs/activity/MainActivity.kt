package chenyijie.sodalabs.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Rect
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import chenyijie.sodalabs.R
import chenyijie.sodalabs.common.ConstValues
import chenyijie.sodalabs.controller.Mp3Controller
import chenyijie.sodalabs.databinding.ActivityMainBinding
import chenyijie.sodalabs.viewmodel.MainActivityViewModel


class MainActivity : BaseActivity() {
    private val controller by lazy { Mp3Controller() }
    private val mediaPlayer by lazy { MediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, getLayoutId())
        binding.vm = viewModel as MainActivityViewModel
        setRecyclerView(binding)

        controller.setData(getLocalMp3Assets(this))

        controller.clickEvent.observe(this, Observer {
            if (it != null) {
                playAssetSound(this, it)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    private fun setRecyclerView(binding: ActivityMainBinding) {
        binding.recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                outRect.top = resources.getDimensionPixelSize(R.dimen.common_component_size_dp_1)
            }
        })

        binding.recyclerView.setController(controller)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun createViewModel(): ViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
    }

    private fun getLocalMp3Assets(context: Context): List<String> {
        return context.assets.list("").toList().filter { it.contains(ConstValues.FILE_POSTFIX) }
    }

    private fun playAssetSound(context: Context, fileName: String) {
        try {

            val descriptor = context.assets.openFd(fileName)
            mediaPlayer.setDataSource(descriptor.fileDescriptor, descriptor.startOffset, descriptor.length)
            descriptor.close()

            mediaPlayer.prepare()
            mediaPlayer.setVolume(1f, 1f)
            mediaPlayer.isLooping = false
            mediaPlayer.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
