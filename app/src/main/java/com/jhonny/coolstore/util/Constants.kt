package com.jhonny.coolstore.util

const val TIMEOUT = 2L
const val DELAY_500L = 500L
const val DELAY_ML_SHORT = 300L

data class ImageData (val code: String, val image : String)
const val VOUCHER = "https://imgs.search.brave.com/GjFqOt_8y0RHzWPdoK8N5nCok6_auoKv8bOIO4b-E_g/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jZG4t/aWNvbnMtcG5nLmZy/ZWVwaWsuY29tLzI1/Ni8xMzc2LzEzNzYz/ODgucG5nP3NlbXQ9/YWlzX2h5YnJpZA"
const val TSHIRT = "https://icons.veryicon.com/png/o/clothes-accessories/spring-fashion-new-clothing-series/t-shirt-59.png"
const val MUG = "https://imgs.search.brave.com/BUPzYhBTviLUONNlubh88SC361UY3ej6axCRs1mMoXs/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jZG4t/aWNvbnMtcG5nLmZy/ZWVwaWsuY29tLzI1/Ni8xMjQwOS8xMjQw/OTc3OS5wbmc_c2Vt/dD1haXNfaHlicmlk"

val IMAGE_LIST = listOf(ImageData(code ="VOUCHER", image = VOUCHER ),
ImageData(code ="TSHIRT", image = TSHIRT),
ImageData(code ="MUG", image = MUG))

