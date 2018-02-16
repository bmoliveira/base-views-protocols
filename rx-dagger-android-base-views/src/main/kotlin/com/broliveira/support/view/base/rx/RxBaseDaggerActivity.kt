package com.broliveira.support.view.base.rx

import android.os.Bundle
import android.support.annotation.CallSuper
import com.broliveira.protocol.BindableView
import com.broliveira.protocol.Disposer
import com.broliveira.support.view.base.BaseDaggerActivity
import io.reactivex.disposables.CompositeDisposable

abstract class RxBaseDaggerActivity : BaseDaggerActivity(), Disposer, BindableView {
  override val disposeBag: CompositeDisposable = CompositeDisposable()

  @CallSuper
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindValues()
  }

  @CallSuper
  override fun onStart() {
    super.onStart()
    bindUIComponents()
  }

  @CallSuper
  override fun onPause() {
    super.onPause()
    clearDisposeBag()
  }

  @CallSuper
  override fun onDestroy() {
    super.onDestroy()
    dispose()
  }
}
