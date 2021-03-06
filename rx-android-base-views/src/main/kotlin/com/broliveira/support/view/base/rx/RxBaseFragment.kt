package com.broliveira.support.view.base.rx

import android.os.Bundle
import android.support.annotation.CallSuper
import com.broliveira.protocol.BindableView
import com.broliveira.protocol.Disposer
import com.broliveira.support.view.base.BaseFragment
import io.reactivex.disposables.CompositeDisposable

abstract class RxBaseFragment: BaseFragment(), Disposer, BindableView {
  override val disposeBag: CompositeDisposable = CompositeDisposable()

  @CallSuper
  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    bindValues()
  }

  @CallSuper
  override fun onStart() {
    super.onStart()
    bindUIComponents()
  }

  @CallSuper
  override fun onPause() {
    clearDisposeBag()
    super.onPause()
  }

  @CallSuper
  override fun onDestroy() {
    dispose()
    super.onDestroy()
  }
}
