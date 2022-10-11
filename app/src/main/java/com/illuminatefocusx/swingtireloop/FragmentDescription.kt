package com.illuminatefocusx.swingtireloop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_description.*

class FragmentDescription : Fragment() {

    var inputName: String = ""
    var inputImage: Int? = null
    var inputDesc: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_description,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        inputName = arguments?.getString("input_title").toString()
        inputImage = arguments?.getInt("input_image")
        inputDesc = arguments?.getString("input_description").toString()

        imageDescription.setImageResource(inputImage!!)
        titleDescription.text = inputName
        descriptionDescription.text = inputDesc

    }

}