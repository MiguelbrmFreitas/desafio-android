package com.picpay.desafio.android.util.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.util.components.RecyclerComponent

@BindingAdapter("bindRecycler")
fun setAdapter(view: RecyclerView, settings: RecyclerComponent?) {
    try {
        view.apply {
            settings?.let {
                it.setRecyclerView(this)

                this.layoutManager = it.layoutManager ?: object : LinearLayoutManager(context) {
                    override fun canScrollVertically(): Boolean {
                        return it.canScrollVertically
                    }
                }
                it.adapter?.let { adapter ->
                    this.adapter = adapter
                }
            }
        }
    } catch (e: Exception) {
        e.stackTrace
    }
}