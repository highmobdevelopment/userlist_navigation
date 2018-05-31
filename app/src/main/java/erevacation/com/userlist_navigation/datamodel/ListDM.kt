package erevacation.com.userlist_navigation.datamodel

import com.erevacation.networking.networkmodel.ListNM

data class ListDM(
     var name : String = "",
     var surname : String = "",
     var image : String = "",
     var contactDetails : Details = Details("", Details.Phones("", ""),"")){
     data class Details(
             var email : String,
             var phones : Phones = Phones("",""),
             var address : String) {
         data class Phones(
                 var home: String,
                 var work: String) {

         constructor(phones: ListNM.Details.Phones) : this(
                 phones.home,
                 phones.work
         )
     }
         constructor(details: ListNM.Details) : this(
                 details.email,
                 Phones(details.phones),
                 details.address
         )

   }
    constructor(listNM: ListNM):this(
            listNM.name,
            listNM.surname,
            listNM.image,
            Details(listNM.contactDetails)
    )
}
