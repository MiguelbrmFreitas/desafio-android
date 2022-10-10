package com.picpay.desafio.android.ui.main.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.domain.entities.User

class UserListItemViewHolder(
    val view: ListItemUserBinding
) : RecyclerView.ViewHolder(view.root) {

    fun bind(user: User) {
        view.apply {
            name = user.name
            username = user.username

            ivPicture.load(user.img) {
                placeholder(createCircularProgressDrawable(root.context))
                error(R.drawable.ic_round_account_circle)
            }
        }
    }

    private fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        return circularProgressDrawable
    }
}