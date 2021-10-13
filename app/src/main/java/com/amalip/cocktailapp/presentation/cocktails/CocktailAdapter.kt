package com.amalip.cocktailapp.presentation.cocktails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amalip.cocktailapp.core.utils.LayoutType
import com.amalip.cocktailapp.databinding.GridCocktailBinding
import com.amalip.cocktailapp.databinding.RowCocktailBinding
import com.amalip.cocktailapp.domain.model.Cocktail

/**
 * Created by Amalip on 9/29/2021.
 */

@SuppressLint("NotifyDataSetChanged")
class CocktailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Cocktail> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    lateinit var listener: (cocktail: Cocktail) -> Unit

    fun addData(list: List<Cocktail>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    fun changeView(layoutType: LayoutType) {
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        LayoutType.LINEAR.ordinal -> ViewHolderItem(
            RowCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        else -> ViewHolderGridItem(
            GridCocktailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size
}

class ViewHolderItem(private val binding: RowCocktailBinding) :
    BaseViewHolder(binding.root) {

    override fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit) {
        binding.item = data

        binding.root.setOnClickListener {
            listener(data)
        }
    }
}

class ViewHolderGridItem(private val binding: GridCocktailBinding) :
    BaseViewHolder(binding.root) {

    override fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit) {
        binding.item = data

        binding.root.setOnClickListener {
            listener(data)
        }
    }
}

abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

    abstract fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit)

}