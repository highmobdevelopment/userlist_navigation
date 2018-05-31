package erevacation.com.userlist_navigation.injection.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist_navigation.injection.provider.FragmentProvider
import erevacation.com.userlist_navigation.ui.homescreen.HomeActivity
import erevacation.com.userlist_navigation.ui.homescreen.HomeActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    internal abstract fun bindHomeActivity(): HomeActivity

}