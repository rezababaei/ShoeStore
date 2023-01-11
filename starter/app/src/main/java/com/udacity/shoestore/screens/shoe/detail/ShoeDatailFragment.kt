package com.udacity.shoestore.screens.shoe.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewmodel.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDatailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.isValidText


class ShoeDatailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDatailBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_datail, container, false)
        binding.lifecycleOwner = this
        binding.shoeViewModel = shoeViewModel


        shoeViewModel.eventAddShoe.observe(viewLifecycleOwner) { eventAddShoe ->
            if (eventAddShoe) {
                addShoe()
                shoeViewModel.onAddShoe()
            }
        }

        shoeViewModel.eventCancelShoeDetail.observe(viewLifecycleOwner) { eventCancelShoeDetail ->
            if (eventCancelShoeDetail) {
                cancel()
                shoeViewModel.onCancelShoeDetail()
            }

        }

//        binding.cancelButton.setOnClickListener {
//
//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addShoe() {
        if (validateShoeDetail()) {
            val result = shoeViewModel.addShoeDetail()
            if (result == true) {
                Toast.makeText(context, "Shoe ${binding.nameEdit.text} added!", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigateUp()
            }
        }
    }

    private fun validateShoeDetail(): Boolean {
        val editTextList = listOf(binding.nameEdit,
            binding.companyEdit,
            binding.sizeEdit,
            binding.descriptionEdit)

        for (et in editTextList) {
            if (!et.isValidText()) {
                Toast.makeText(context,
                    "Please Enter ${et.contentDescription}",
                    Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun cancel() {
        findNavController().navigateUp()
    }

}