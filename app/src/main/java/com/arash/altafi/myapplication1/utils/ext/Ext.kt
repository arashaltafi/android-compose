package com.arash.altafi.myapplication1.utils.ext

import com.arash.altafi.myapplication1.data.model.FavoriteUserEntity
import com.arash.altafi.myapplication1.data.model.ResponseUsers

// Extension function to convert User to FavoriteUserEntity
fun ResponseUsers.toFavoriteUserEntity(): FavoriteUserEntity {
    return FavoriteUserEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        phone = this.phone,
        website = this.website,
        companyName = this.company.name
    )
}