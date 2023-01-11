package com.udacity.shoestore.screens.shoe.list

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewmodel.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)

        shoeViewModel.user.observe(viewLifecycleOwner) { user ->
            if (user == null) {
                userLogin()
            } else {
                Log.d("ShoeListFragment", "onCreateView: creaeted")
                shoeViewModel.shoeList.observe(viewLifecycleOwner) { shoes ->
                    for (shoe in shoes) {
                        val shoeItemTextView = TextView(context)
                        shoeItemTextView.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
                        shoeItemTextView.textSize = 16f
                        shoeItemTextView.text =
                            "name: ${shoe.name}   Company: ${shoe.company}  Size: ${shoe.size}"
                        binding.shoeListLayout.addView(shoeItemTextView)
                    }
                }
//
                binding.addShowFab.setOnClickListener {
                    findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDatailFragment())
                }

                //setting the Menu
                setHasOptionsMenu(true)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun userLogin() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginFragment) {
            shoeViewModel.userLogout()
        }
        return super.onOptionsItemSelected(item)
    }
}