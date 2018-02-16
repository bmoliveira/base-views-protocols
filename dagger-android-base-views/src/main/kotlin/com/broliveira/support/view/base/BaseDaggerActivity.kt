package com.broliveira.support.view.base

import com.broliveira.protocol.ActivityCurrentFragmentFinder
import com.broliveira.protocol.ActivityFragmentBackHandler
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseDaggerActivity : DaggerAppCompatActivity(),
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

  open fun forcedBack() {
    super.onBackPressed()
  }
}
