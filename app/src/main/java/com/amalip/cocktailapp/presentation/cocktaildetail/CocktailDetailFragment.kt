package com.amalip.cocktailapp.presentation.cocktaildetail

import android.view.View
import com.amalip.cocktailapp.R
import com.amalip.cocktailapp.core.presentation.BaseFragment
import com.amalip.cocktailapp.databinding.CocktailDetailFragmentBinding

class CocktailDetailFragment : BaseFragment(R.layout.cocktail_detail_fragment) {

    private lateinit var binding: CocktailDetailFragmentBinding

    override fun setBinding(view: View) {

        binding = CocktailDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@CocktailDetailFragment
            //cocktail = requireArguments()
        }

    }

}