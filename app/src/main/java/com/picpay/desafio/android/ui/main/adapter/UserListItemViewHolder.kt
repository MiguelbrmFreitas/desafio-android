package com.picpay.desafio.android.ui.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.domain.entities.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListItemViewHolder(
    val view: ListItemUserBinding
) : RecyclerView.ViewHolder(view.root) {

    fun bind(user: User) {
        view.apply {
            name = user.name
            username = user.username

            ivPicture.load(user.img) {
                placeholder(R.drawable.ic_round_account_circle)
            }
        }
//        itemView.name.text = user.name
//        itemView.username.text = user.username
//        itemView.progressBar.visibility = View.VISIBLE
//        Picasso.get()
//            .load(user.img)
//            .error(R.drawable.ic_round_account_circle)
//            .into(itemView.picture, object : Callback {
//                override fun onSuccess() {
//                    itemView.progressBar.visibility = View.GONE
//                }
//
//                override fun onError(e: Exception?) {
//                    itemView.progressBar.visibility = View.GONE
//                }
//            })
    }
}