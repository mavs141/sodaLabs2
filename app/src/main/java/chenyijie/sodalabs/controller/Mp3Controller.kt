package chenyijie.sodalabs.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import chenyijie.sodalabs.mp3Info
import com.airbnb.epoxy.TypedEpoxyController

class Mp3Controller : TypedEpoxyController<List<String>>() {
    private val _clickEvent = MutableLiveData<String>()
    val clickEvent: LiveData<String> get() = _clickEvent

    override fun buildModels(data: List<String>?) {
        data?.forEachIndexed { index, string ->
            mp3Info {
                id("mp3 file $index")
                fileName(string)
                clickEvent { _ -> _clickEvent.postValue(string) }
            }
        }
    }

}