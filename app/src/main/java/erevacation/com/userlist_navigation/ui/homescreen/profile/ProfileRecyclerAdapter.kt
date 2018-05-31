package erevacation.com.userlist_navigation.ui.homescreen.profile

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.erevacation.widgets.R
import erevacation.com.userlist_navigation.databinding.ViewHolderProfileBinding

class ProfileRecyclerAdapter(val presenter: ProfileFragmentPresenter)
    : RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder>() {


    private val profileInfoList: ArrayList<String> = arrayListOf()

    private var listOfIcons: ArrayList<Int> = arrayListOf(
            R.drawable.email_ico
            , R.drawable.home_address_ico
            , R.drawable.home_phone_ico
            , R.drawable.mobile_phone_ico)

    private var listOfMenuField: ArrayList<Int> = arrayListOf(
            R.string.menu_field_email
            , R.string.menu_field_address
            , R.string.menu_field_home_phone
            , R.string.menu_field_mobile_phone)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = ViewHolderProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return profileInfoList.size
    }


    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(profileInfoList[position], listOfIcons[position], listOfMenuField[position])

    }

    fun updateUserDetails(data: ArrayList<String>) {
        this.profileInfoList.clear()
        this.profileInfoList.addAll(data)
        notifyDataSetChanged()

    }

    class ProfileViewHolder(binding: ViewHolderProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bind(data: String, icon: Int, menuField: Int) {
            binding.profileFragmentCard.setProfileDataApperance(data, icon, menuField)
        }
    }

}