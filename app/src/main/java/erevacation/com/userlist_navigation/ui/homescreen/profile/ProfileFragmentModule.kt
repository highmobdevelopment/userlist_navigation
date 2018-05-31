package erevacation.com.userlist_navigation.ui.homescreen.profile

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProfileFragmentModule {
    @Provides
    internal fun provideProfilePresenter(presenter: ProfileFragmentPresenter): ProfileContract.ProfilePresenter {
        return presenter
    }

    @Provides
    @Named("fragmentContext")
    fun provideFragmentContext(profileFragment: ProfileFragment): Context? {
        return profileFragment.context
    }

}