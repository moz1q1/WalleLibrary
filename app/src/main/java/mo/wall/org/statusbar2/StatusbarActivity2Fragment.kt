package mo.wall.org.statusbar2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.View
import mo.wall.org.R
import org.wall.mo.base.fragment.InterceptActBackFragment

/**
 * A placeholder fragment containing a simple view.
 */
class StatusbarActivity2Fragment : InterceptActBackFragment() {
    override fun getTopBarTitleViewId(): Int {
        return -1
    }

    override fun getTopBarBackViewId(): Int {
        return -1
    }

    override fun showLongToast(msg: String?) {

    }

    override fun parseIntentData(intent: Intent?) {

    }

    override fun showShortToast(msg: String?) {

    }

    override fun hideDialog() {

    }

    override fun showDialog(msg: String?) {

    }


    override fun handleSubMessage(msg: Message?) {

    }


    companion object {
        fun newInstance(args: Bundle?): Fragment {
            val fragment: Fragment? = StatusbarActivity2Fragment()
            args?.putString(TAG, TAG)
            fragment!!.arguments = args
            return fragment
        }
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {

    }

    override fun initClick() {

    }


    override fun initData() {

    }

    override fun onFragmentInterceptOnBackPressed(): Boolean {
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_statusbar2
    }

    override fun onFragmentInterceptGetIntent(intent: Intent?): Boolean {
        return false
    }

    override fun onAbsV4Attach(context: Context?) {

    }

}
