package erevacation.com.userlist_navigation.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist_navigation.ui.homescreen.list.ListFragment
import erevacation.com.userlist_navigation.ui.homescreen.list.ListFragmentModule
import erevacation.com.userlist_navigation.ui.homescreen.profile.ProfileFragment
import erevacation.com.userlist_navigation.ui.homescreen.profile.ProfileFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment

    @ContributesAndroidInjector(modules = [(ProfileFragmentModule::class)])
    abstract fun provideProfileFragmentFactory(): ProfileFragment

}