package com.gb.m_1919_1872_1.view.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.FragmentEarthBinding


class EarthFragment : Fragment() {


    private var _binding: FragmentEarthBinding? = null
    private val binding: FragmentEarthBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance() = EarthFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}