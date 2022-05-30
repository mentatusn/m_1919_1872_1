package com.gb.m_1919_1872_1.view.settings

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.FragmentSettingsBinding
import com.google.android.material.tabs.TabLayout


class SettingsFragment : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.position}", Toast.LENGTH_SHORT).show()

                when (tab?.position) {
                    /* TODO HW
                     when(position){
                        1->{viewModel.sendRequestToday()}
                        2->{viewModel.sendRequestYT()}
                        3->{viewModel.sendRequestTDBY()}
                    }

                    when(position){
                        1->{viewModel.sendRequest(date)}
                        2->{viewModel.sendRequest(date-1)}
                        3->{viewModel.sendRequest(date-2)}
                    }*/
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}

open class A {
    @CallSuper
    open fun onAnimationStart() {
        Log.d("","")
    }
}

class B:A() {
    override fun onAnimationStart(){
        super.onAnimationStart()
        Log.d("","")
    }
}