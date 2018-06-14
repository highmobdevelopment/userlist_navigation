package erevacation.com.userlist_navigation.ui.homescreen

import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract

interface HomeContract {

    interface HomeView : ViperContract.View<HomePresenter> {

    }

    interface HomePresenter : ViperContract.Presenter {

    }
}