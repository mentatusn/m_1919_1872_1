package com.gb.m_1919_1872_1.view.layout.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.FragmentConstraintBinding
import com.gb.m_1919_1872_1.databinding.FragmentEarthBinding


class ConstraintFragment : Fragment() {


    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance() = ConstraintFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}