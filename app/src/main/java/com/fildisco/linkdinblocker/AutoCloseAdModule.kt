package com.fildisco.linkdinblocker

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
import android.view.View

class AutoCloseAdModule : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: LoadPackageParam) {
        if (lpparam.packageName != "com.linkedin.android") return

        findAndHookMethod(
            "com.linkedin.android.feed.pages.disinterest.FeedDisinterestActionPresenter\$createReportButtonClickListener\$1",
            lpparam.classLoader,
            "onClick",
            View::class.java,
            object : XC_MethodHook() {
                @Throws(Throwable::class)
                override fun beforeHookedMethod(param: MethodHookParam) {
                    // Your code before the original method executes
                }

                @Throws(Throwable::class)
                override fun afterHookedMethod(param: MethodHookParam) {
                    // Your code after the original method executes
                }
            }
        )
    }
}