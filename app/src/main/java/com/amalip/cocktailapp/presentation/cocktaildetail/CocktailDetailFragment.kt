package com.amalip.cocktailapp.presentation.cocktaildetail

import android.view.View
import androidx.navigation.fragment.navArgs
import com.amalip.cocktailapp.R
import com.amalip.cocktailapp.core.presentation.BaseFragment
import com.amalip.cocktailapp.databinding.CocktailDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
class CocktailDetailFragment : BaseFragment(R.layout.cocktail_detail_fragment) {

    private lateinit var binding: CocktailDetailFragmentBinding
    private val args: CocktailDetailFragmentArgs by navArgs()

    override fun setBinding(view: View) {

        binding = CocktailDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@CocktailDetailFragment
            cocktail = args.cocktail
        }

    }

}