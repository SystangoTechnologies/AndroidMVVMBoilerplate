package com.systango.mvvm.utils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 *
 * This is a fragment utility class which is responsible for add ,replace fragment
 */
object FragmentHelper {
    private val TAG = FragmentHelper::class.java.simpleName

    /**
     * @param fragment
     * @param container
     * @param fm
     */
    fun addAndInitFragment(fragment: Fragment, container: Int, fm: FragmentManager) {
        val ft = fm.beginTransaction()
        ft.add(container, fragment, fragment.javaClass.simpleName)
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit()
    }

    /**
     * @param fragment
     * @param container
     * @param fm
     */
    @JvmStatic
    fun replaceAndInitFragment(fragment: Fragment, container: Int, fm: FragmentManager) {
        val ft = fm.beginTransaction()
        ft.replace(container, fragment, fragment.javaClass.simpleName)
        //  ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit()
    }

    /**
     * @param fragment
     * @param container
     * @param fm
     */
    @JvmStatic
    fun addAndInitFragmentWithBackStack(fragment: Fragment, container: Int, fm: FragmentManager) {
        try {
            val tag = fragment.javaClass.simpleName
            if (!fragment.isAdded) {
                val ft = fm.beginTransaction()
                ft.add(container, fragment, tag)
                // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(tag)
                ft.commit()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Logger.e(TAG, e.message)
        }

    }

    /**
     * @param fragment
     * @param container
     * @param fm
     */
    fun replaceAndInitFragmentWithBackStack(
        fragment: Fragment,
        container: Int,
        fm: FragmentManager
    ) {
        val tag = fragment.javaClass.simpleName
        val ft = fm.beginTransaction()
        ft.replace(container, fragment, tag)
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(tag)
        ft.commit()
    }

    /**
     * @param tag
     * @param fm  Fragment manager
     */
    fun findFragmentByTag(tag: String, fm: FragmentManager?): Fragment? {
        var fragment: Fragment? = null
        if (fm != null && fm.findFragmentByTag(tag) != null) {
            fragment = fm.findFragmentByTag(tag)
        }
        return fragment
    }

    fun removeFragment(tag: String, fm: FragmentManager?): Fragment? {
        var fragment: Fragment? = null
        if (fm != null && fm.findFragmentByTag(tag) != null) {
            fragment = fm.findFragmentByTag(tag)
        }
        return fragment
    }

}
