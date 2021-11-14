package com.example.shoppify.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.shoppify.R
import com.example.shoppify.firestore.FirestoreClass
import com.example.shoppify.models.User
import com.example.shoppify.utils.Constants
import com.example.shoppify.utils.GlideLoader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.activity_settings.toolbar_settings_activity as toolbar_settings_activity1
import kotlinx.android.synthetic.main.activity_user_profile.iv_user_photo as iv_user_photo1

class SettingsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var mUserDetails: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setupActionBar()
        tv_edit.setOnClickListener(this)
        btn_logout.setOnClickListener(this)
        ll_address.setOnClickListener(this@SettingsActivity)
    }

    override fun onResume() {
        super.onResume()
        getUserDetails()
    }

   private fun setupActionBar() {

        setSupportActionBar(this.toolbar_settings_activity1)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_settings_activity1.setNavigationOnClickListener { onBackPressed() }
    }

    private fun getUserDetails() {

        showProgressDialog(resources.getString(R.string.please_wait))

        FirestoreClass().getUserDetails(this@SettingsActivity)
    }

    fun userDetailsSuccess(user: User) {

        mUserDetails = user
        hideProgressDialog()

        // Load the image using the Glide Loader class.
        GlideLoader(this@SettingsActivity).loadUserPicture(user.image, iv_user_photo)

        tv_name.text = "${user.firstName} ${user.lastName}"
        tv_gender.text = user.gender
        tv_email.text = user.email
        tv_mobile_number.text = "${user.mobile}"

    }


    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

               R.id.tv_edit -> {
                    val intent = Intent(this@SettingsActivity, UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS, mUserDetails)
                    startActivity(intent)
                }

                R.id.btn_logout -> {

                    FirebaseAuth.getInstance().signOut()

                    val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                R.id.ll_address -> {
                    val intent = Intent(this@SettingsActivity, AddressListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}