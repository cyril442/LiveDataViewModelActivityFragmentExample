package androidviakotlin.sharedviewmodelexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_output.*


class OutputFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        activity?.let {
            val viewModel = ViewModelProviders.of(it).get(WordViewModel::class.java)

            observeInput(viewModel)
        }
    }

    private fun observeInput(wordViewModel: WordViewModel) {
        wordViewModel.inputWord.observe(this, Observer {
            it?.let {
                val numberOfChar = resources.getString(R.string.number_of_char)

                TextView_outputWiThWordOfTheUser.text = "$it"
                TextView_output_number_of_characters.text = "$numberOfChar  ${(it.length)}"

            }
        })
    }


}
