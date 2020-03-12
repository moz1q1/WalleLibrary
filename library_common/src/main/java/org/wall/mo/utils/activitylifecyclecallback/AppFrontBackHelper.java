package org.wall.mo.utils.activitylifecyclecallback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * https://blog.csdn.net/bzlj2912009596/article/details/80073396
 * https://www.jianshu.com/p/6abb22937e6f
 * Copyright (C), 2018-2018
 * Author: ziqimo
 * Date: 2018/12/13 下午1:40
 * Description: ${DESCRIPTION}
 * History:应用前后台状态监听帮助类，仅在Application中使用
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class AppFrontBackHelper {

    private OnAppStatusListener mOnAppStatusListener;


    public AppFrontBackHelper() {

    }

    /**
     * 注册状态监听，仅在Application中使用
     *
     * @param application
     * @param listener
     */
    public void register(Application application, AppFrontBackHelper.OnAppStatusListener listener) {
        mOnAppStatusListener = listener;
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        //打开的Activity数量统计
        private int activityStartCount = 0;

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            activityStartCount++;
            //数值从0变到1说明是从后台切到前台
            if (activityStartCount == 1) {
                //从后台切到前台
                if (mOnAppStatusListener != null) {
                    mOnAppStatusListener.onFront();
                }
            }
        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            activityStartCount--;
            //数值从1到0说明是从前台切到后台
            if (activityStartCount == 0) {
                //从前台切到后台
                if (mOnAppStatusListener != null) {
                    mOnAppStatusListener.onBack();
                }
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    public interface OnAppStatusListener {
        public void onFront();

        public void onBack();
    }
}