package com.erevacation.networking.networkmodel

data class ListNM(
     var name : String = "",
     var surname : String = "",
     var image : String = "",
     var contactDetails : Details = Details("", Details.Phones("", ""),"")){
     data class Details(
             var email : String,
             var phones : Phones = Phones("",""),
             var address : String) {
        data class Phones(
                var home : String,
                var work : String)

   }
}
