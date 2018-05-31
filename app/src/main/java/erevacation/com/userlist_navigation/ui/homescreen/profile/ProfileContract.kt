package erevacation.com.userlist_navigation.ui.homescreen.profile

import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract

interface ProfileContract {


    interface ProfileView : ViperContract.View<ProfilePresenter> {

    }

    interface ProfilePresenter : ViperContract.Presenter {

    }

}