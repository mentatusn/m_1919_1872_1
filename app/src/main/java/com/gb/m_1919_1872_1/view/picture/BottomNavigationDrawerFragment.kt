package com.gb.m_1919_1872_1.view.picture

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.BottomNavigationLayoutBinding
import com.gb.m_1919_1872_1.databinding.FragmentPictureOfTheDayBinding
import com.gb.m_1919_1872_1.repository.PictureOfTheDayResponseData
import com.gb.m_1919_1872_1.view.MainActivity
import com.gb.m_1919_1872_1.viewmodel.PictureOfTheDayAppState
import com.gb.m_1919_1872_1.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    val binding: BottomNavigationLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_one ->{
                    Log.d("@@@","На экран 1")
                }
                R.id.navigation_two ->{
                    Log.d("@@@","На экран 2")
                }
            }
            true
        }
    }




    companion object {
        @JvmStatic
        fun newInstance() = BottomNavigationDrawerFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}