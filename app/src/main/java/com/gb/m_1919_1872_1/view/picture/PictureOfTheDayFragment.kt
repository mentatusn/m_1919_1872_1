package com.gb.m_1919_1872_1.view.picture


import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.FragmentPictureOfTheDayBinding
import com.gb.m_1919_1872_1.view.MainActivity
import com.gb.m_1919_1872_1.view.settings.SettingsFragment
import com.gb.m_1919_1872_1.viewmodel.PictureOfTheDayAppState
import com.gb.m_1919_1872_1.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip


class PictureOfTheDayFragment : Fragment() {


    var isMain = true
    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.app_bar_fav -> {
                Log.d("@@@", "app_bar_fav")
            }
            R.id.app_bar_settings -> {
                Log.d("@@@", "app_bar_settings")
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SettingsFragment.newInstance()).commit()
                // TODO HW addToBAckstack
            }
            android.R.id.home -> {
                BottomNavigationDrawerFragment.newInstance()
                    .show(requireActivity().supportFragmentManager, "")
            }
        }
        return super.onOptionsItemSelected(item)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.sendRequest()

        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.lifeHack.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        /*binding.lifeHack.bottomSheetContainer.z= 40f
        binding.fab.z= 100f*/

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {}
                    BottomSheetBehavior.STATE_COLLAPSED -> {}
                    BottomSheetBehavior.STATE_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("@@@", "$slideOffset")
            }

        })

        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)

        binding.fab.setOnClickListener {
            if (isMain) {
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                // TODO HW  binding.bottomAppBar.replaceMenu(// R.menu. какое-то другое меню)
            } else {
                binding.bottomAppBar.navigationIcon = (ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_hamburger_menu_bottom_bar
                ))
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                // TODO HW binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
            isMain = !isMain
        }


        binding.chipGroup.setOnCheckedChangeListener { group, position ->
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
            group.findViewById<Chip>(position)?.let {
                Log.d("@@@", "${it.text.toString()} $position")
            }
        }
    }


    private fun renderData(pictureOfTheDayAppState: PictureOfTheDayAppState) {
        when (pictureOfTheDayAppState) {
            is PictureOfTheDayAppState.Error -> {}
            is PictureOfTheDayAppState.Loading -> {}
            is PictureOfTheDayAppState.Success -> {
                binding.imageView.load(pictureOfTheDayAppState.pictureOfTheDayResponseData.url) {
                    // TODO HW скрасить ожидание картинки
                }
                //binding.lifeHack.title.typeface = Typeface.createFromAsset(requireActivity().assets,"azeret.ttf")
                binding.lifeHack.title.typeface =
                    Typeface.createFromAsset(requireActivity().assets, "level1/level2/azeret.ttf")
                binding.lifeHack.title.text =
                    pictureOfTheDayAppState.pictureOfTheDayResponseData.title
                binding.lifeHack.explanation.text =
                    pictureOfTheDayAppState.pictureOfTheDayResponseData.explanation


                // val text = requireActivity().resources.getText(R.string.test_html).toString()
                val text = "My text <ul><li>bullet one</li><li>bullet two</li>"
                //binding.lifeHack.explanation.text=Html.fromHtml(text)
                val textSpannable =
                    "My text \nbullet one \nbullet two\nbullet one \nbullet two\nbullet one \nbullet twowefgewrgt\nbullet two\nbullet one \nbullet twowefgewrgt\nbullet two\nbullet one \nbullet twowefgewrgt\nbullet two\nbullet one \nbullet twowefgewrgt\nbullet two\nbullet one \nbullet twowefgewrgt"


                val spannedString: SpannedString
                val spannableString: SpannableString = SpannableString(textSpannable)
                val spannableStringBuilder: SpannableStringBuilder

                //val list = textSpannable.indexesOf("\n")
                val list = indexesOfMy("\n",textSpannable)

                Log.d("mylogs","${textSpannable.indexOf("NNN")}")
                Log.d("mylogs","${indexesOfMy("\n",textSpannable)}")
                Log.d("mylogs","${textSpannable.indexesOf("\n")}")


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {

                    var current = list.first()
                    list.forEach {
                        if (current != it) {
                            spannableString.setSpan(
                                BulletSpan(
                                    20,
                                    ContextCompat.getColor(requireContext(), R.color.red_700),
                                    10
                                ),
                                current + 1, it, SpannedString.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                        }
                        current = it
                    }
                    spannableString.setSpan(
                        BulletSpan(
                            20,
                            ContextCompat.getColor(requireContext(), R.color.red_700),
                            10
                        ),
                        current + 1, textSpannable.length, SpannedString.SPAN_EXCLUSIVE_EXCLUSIVE
                    )

                } else {
                    spannableString.setSpan(
                        BulletSpan(20, ContextCompat.getColor(requireContext(), R.color.red_700)),
                        9, 19, SpannedString.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                spannableString.setSpan(
                    ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.red_700)),
                    8, 19, SpannedString.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                spannableString.setSpan(
                    ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.blue)),
                    21, textSpannable.length, SpannedString.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                binding.lifeHack.explanation.text = spannableString

            }
        }
    }

    fun String.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> =
        (if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr))
            .findAll(this).map { it.range.first }.toList()

    fun indexesOfMy(substr: String, string: String): List<Int>  {
        val list = mutableListOf<Int>()
        var mutableString = string
        var current = 0
        while (mutableString.indexOf(substr)!=-1){
            val indexC = mutableString.indexOf(substr)
            list.add(current+indexC)
            current+=indexC+1 // костыль
            mutableString= mutableString.substring(indexC+substr.length)
        }
        return  list
    }

    companion object {
        @JvmStatic
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}