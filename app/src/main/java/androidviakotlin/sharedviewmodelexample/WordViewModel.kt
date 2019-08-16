package androidviakotlin.sharedviewmodelexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class WordViewModel: ViewModel(){
  //  val inputWord = MutableLiveData<Int>()
    val inputWord = MutableLiveData<String>()
}