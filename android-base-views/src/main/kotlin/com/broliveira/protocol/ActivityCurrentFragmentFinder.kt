package com.broliveira.protocol

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

interface ActivityCurrentFragmentFinder {

  /**
   * This is the view container for fragments.
   * Usually the view that is used to execute the fragment transactions.
   * This ID MUST be overridden if the id of the fragment is different from the default one.
   */
  val fragmentContainerId: Int
    get() = android.R.id.content

  /**
   * Return the First "Support" fragment on the Activity.
   */
  val currentSupportFragment: Fragment?
    get() {
      return when (this) {
        this as? AppCompatActivity -> currentFragmentFromSupportManager(this.supportFragmentManager)
        this as? Fragment -> this.activity?.supportFragmentManager?.let { currentFragmentFromSupportManager(it) }
        else -> null
      }
    }

  /**
   * Return the First fragment on the Activity.
   */
  val currentFragment: android.app.Fragment?
    get() {
      return when (this) {
        this as? AppCompatActivity -> currentFragmentFromManager(this.fragmentManager)
        this as? Activity -> currentFragmentFromManager(this.fragmentManager)
        this as? android.app.Fragment -> currentFragmentFromManager(this.activity.fragmentManager)
        this as? Fragment -> this.activity?.fragmentManager?.let { currentFragmentFromManager(it) }
        else -> null
      }
    }

  /**
   * Tries to find the current active Fragment thought support fragment manager.
   *
   * @param supportFragmentManager Android Support fragment manager.
   *
   * @return Current active Fragment if any/found.
   */
  private fun currentFragmentFromSupportManager(supportFragmentManager: FragmentManager): Fragment? {
    if (supportFragmentManager.backStackEntryCount == 0) return findSupportFragment(supportFragmentManager)
    val fragmentTag = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount-1).name
    return supportFragmentManager.findFragmentByTag(fragmentTag)
  }

  private fun findSupportFragment(supportFragmentManager: FragmentManager): Fragment? {
    return try {
      supportFragmentManager.findFragmentById(fragmentContainerId)
    } catch (ignored: Exception) {
      null
    }
  }

  /**
   * Tries to find the current active Fragment thought fragment manager.
   *
   * @param fragmentManager Android fragment manager.
   *
   * @return Current active Fragment if any/found.
   */
  private fun currentFragmentFromManager(fragmentManager: android.app.FragmentManager): android.app.Fragment? {
    if (fragmentManager.backStackEntryCount == 0) return fragmentManager.findFragmentById(fragmentContainerId)
    val fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount-1).name
    return fragmentManager.findFragmentByTag(fragmentTag)
  }

  private fun findFragment(fragmentManager: android.app.FragmentManager): android.app.Fragment? {
    return try {
      fragmentManager.findFragmentById(fragmentContainerId)
    } catch (ignored: Exception) {
      null
    }
  }
}