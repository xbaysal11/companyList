package com.example.companylist

import java.io.Serializable

data class Company(
        val name: String = "",
        val description: String = "",
        val imgRes: Int = -1
) : Serializable