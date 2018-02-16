package com.broliveira.support.view.base

import android.support.v7.app.AppCompatActivity
import com.broliveira.protocol.ActivityCurrentFragmentFinder
import com.broliveira.protocol.ActivityFragmentBackHandler

abstract class BaseActivity: AppCompatActivity(),
    ActivityCurrentFragmentFinder,
    ActivityFragmentBackHandler {

  // Back handler that checks if the fragments have back enabled
  override fun onBackPressed() {
    if(handleFragmentBackPress()) {
      return
    }

    super.onBackPressed()
    afterSuperBackPressed()
  }

  fun forcedBack() {
    super.onBackPressed()
  }
}
