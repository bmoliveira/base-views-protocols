package com.broliveira.view.base.rx

import android.os.Bundle
import com.broliveira.protocol.BindableView
import com.broliveira.protocol.Disposer
import com.broliveira.view.base.BaseActivity
import io.reactivex.disposables.CompositeDisposable

abstract class RxBaseActivity: BaseActivity(), Disposer, BindableView {
  override val disposeBag: CompositeDisposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindValues()
  }

  override fun onStart() {
    super.onStart()
    bindUIComponents()
  }

  override fun onPause() {
    super.onPause()
    clearDisposeBag()
  }

  override fun onDestroy() {
    super.onDestroy()
    dispose()
  }
}
