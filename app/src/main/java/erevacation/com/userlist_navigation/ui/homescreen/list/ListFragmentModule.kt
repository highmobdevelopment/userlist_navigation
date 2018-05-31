package erevacation.com.userlist_navigation.ui.homescreen.list

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ListFragmentModule {
    @Provides
    internal fun provideRequestPresenter(presenter: ListFragmentPresenter): ListContract.ListPresenter {
        return presenter
    }

    @Provides
    @Named("fragmentContext")
    fun provideFragmentContext(listFragment: ListFragment): Context? {
        return listFragment.context
    }
}