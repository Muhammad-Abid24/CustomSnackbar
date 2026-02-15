package com.Custom.Snackbar;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class CustomSnackbar {

    // Default values
    private static final int DEFAULT_TEXT_SIZE = 17;
    private static final int DEFAULT_TEXT_COLOR = 0xFF000000;
    private static final int DEFAULT_BACKGROUND_COLOR = 0xFF4CAF50;
    private static final int DEFAULT_DURATION = Snackbar.LENGTH_SHORT;

    /**
     * Show snackbar with default styling
     */
    public static void showSnackbar(Activity activity, String message) {
        showSnackbarWithColor(activity, message, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with custom duration
     *
     * @param duration Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithDuration(Activity activity, String message, int duration) {
        showSnackbarWithColor(activity, message, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR, duration);
    }

    /**
     * Show snackbar with custom text size
     */
    public static void showSnackbarWithTextSize(Activity activity, String message, int textSize) {
        showSnackbarWithColor(activity, message, textSize, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with custom text size and text color
     */
    public static void showSnackbarWithTextSize(Activity activity, String message, int textSize, int textColor) {
        showSnackbarWithColor(activity, message, textSize, textColor, DEFAULT_BACKGROUND_COLOR, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with full customization using resource IDs
     *
     * @param activity            The activity context
     * @param message             The message to display
     * @param textSize            Text size in sp
     * @param textColorRes        Text color resource ID (e.g., R.color.black)
     * @param backgroundColorRes   Background color resource ID (e.g., R.color.white)
     */
    public static void showSnackbarWithResources(Activity activity, String message, int textSize, int textColorRes, int backgroundColorRes) {
        showSnackbarWithResources(activity, message, textSize, textColorRes, backgroundColorRes, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with full customization using resource IDs and custom duration
     *
     * @param activity            The activity context
     * @param message             The message to display
     * @param textSize            Text size in sp
     * @param textColorRes        Text color resource ID (e.g., R.color.black)
     * @param backgroundColorRes   Background color resource ID (e.g., R.color.white)
     * @param duration            Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithResources(Activity activity, String message, int textSize, int textColorRes, int backgroundColorRes, int duration) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(rootView, message, duration);
        View snackbarView = snackbar.getView();

        // Customizing Snackbar
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(activity, textColorRes));
        textView.setTextSize(textSize);
        textView.setMaxLines(10); // Allow multiple lines
        snackbarView.setBackgroundColor(ContextCompat.getColor(activity, backgroundColorRes));

        snackbar.show();
    }

    /**
     * Show snackbar with color values (instead of resource IDs)
     *
     * @param activity              The activity context
     * @param message               The message to display
     * @param textSize              Text size in sp
     * @param textColor             Text color integer value (e.g., Color.BLACK)
     * @param backgroundColor        Background color integer value (e.g., Color.WHITE)
     */
    public static void showSnackbarWithColor(Activity activity, String message, int textSize, int textColor, int backgroundColor) {
        showSnackbarWithColor(activity, message, textSize, textColor, backgroundColor, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with color values and custom duration
     *
     * @param activity              The activity context
     * @param message               The message to display
     * @param textSize              Text size in sp
     * @param textColor             Text color integer value (e.g., Color.BLACK)
     * @param backgroundColor        Background color integer value (e.g., Color.WHITE)
     * @param duration              Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithColor(Activity activity, String message, int textSize, int textColor, int backgroundColor, int duration) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(rootView, message, duration);
        View snackbarView = snackbar.getView();

        // Customizing Snackbar
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);
        textView.setMaxLines(10); // Allow multiple lines
        snackbarView.setBackgroundColor(backgroundColor);

        snackbar.show();
    }

    // ========== WITH ACTION BUTTON ==========

    /**
     * Show snackbar with action button (default styling)
     *
     * @param actionText    Text for the action button
     * @param clickListener Click listener for the action button
     */
    public static void showSnackbarWithAction(Activity activity, String message, String actionText, View.OnClickListener clickListener) {
        showSnackbarWithAction(activity, message, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR,
                0xFFFFFFFF, actionText, clickListener, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button and custom button background
     *
     * @param actionText    Text for the action button
     * @param actionBgColor Action button background color integer value
     * @param clickListener Click listener for the action button
     */
    public static void showSnackbarWithAction(Activity activity, String message, String actionText, int actionBgColor, View.OnClickListener clickListener) {
        showSnackbarWithAction(activity, message, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR,
                0xFFFFFFFF, actionBgColor, actionText, clickListener, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button and custom colors
     *
     * @param textSize       Text size in sp
     * @param textColor      Message text color integer value
     * @param backgroundColor Background color integer value
     * @param actionColor    Action button text color integer value
     * @param actionText     Text for the action button
     * @param clickListener  Click listener for the action button
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, String actionText,
                                              View.OnClickListener clickListener) {
        showSnackbarWithAction(activity, message, textSize, textColor, backgroundColor, actionColor, actionText, clickListener, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button, custom colors, and custom duration
     *
     * @param textSize       Text size in sp
     * @param textColor      Message text color integer value
     * @param backgroundColor Background color integer value
     * @param actionColor    Action button text color integer value
     * @param actionText     Text for the action button
     * @param clickListener  Click listener for the action button
     * @param duration       Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, String actionText,
                                              View.OnClickListener clickListener, int duration) {
        showSnackbarWithAction(activity, message, textSize, textColor, backgroundColor, actionColor, 0, actionText, clickListener, duration);
    }

    /**
     * Show snackbar with action button, including button background color
     *
     * @param textSize         Text size in sp
     * @param textColor        Message text color integer value
     * @param backgroundColor  Background color integer value
     * @param actionColor      Action button text color integer value
     * @param actionBgColor    Action button background color integer value (0 = transparent/default)
     * @param actionText       Text for the action button
     * @param clickListener    Click listener for the action button
     * @param duration         Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, int actionBgColor, String actionText,
                                              View.OnClickListener clickListener, int duration) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(rootView, message, duration);
        View snackbarView = snackbar.getView();

        // Customizing Snackbar
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);
        textView.setMaxLines(10); // Allow multiple lines
        snackbarView.setBackgroundColor(backgroundColor);

        // Set action button
        snackbar.setActionTextColor(actionColor);
        snackbar.setAction(actionText, clickListener);

        // Set action button background color if specified
        if (actionBgColor != 0) {
            snackbar.addCallback(new Snackbar.Callback() {
                @Override
                public void onShown(Snackbar sb) {
                    View actionView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_action);
                    if (actionView != null) {
                        actionView.setBackgroundColor(actionBgColor);
                        // Add padding for better appearance
                        int px = (int) (8 * activity.getResources().getDisplayMetrics().density);
                        actionView.setPadding(px, px / 2, px, px / 2);
                    }
                }
            });
        }

        snackbar.show();
    }

    /**
     * Show snackbar with action button using color resources
     *
     * @param textSize            Text size in sp
     * @param textColorRes        Message text color resource ID (e.g., R.color.black)
     * @param backgroundColorRes  Background color resource ID (e.g., R.color.white)
     * @param actionColorRes      Action button text color resource ID
     * @param actionText          Text for the action button
     * @param clickListener       Click listener for the action button
     */
    public static void showSnackbarWithActionResources(Activity activity, String message, int textSize, int textColorRes,
                                                        int backgroundColorRes, int actionColorRes, String actionText,
                                                        View.OnClickListener clickListener) {
        showSnackbarWithActionResources(activity, message, textSize, textColorRes, backgroundColorRes, actionColorRes, actionText, clickListener, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button using color resources and custom duration
     *
     * @param textSize            Text size in sp
     * @param textColorRes        Message text color resource ID (e.g., R.color.black)
     * @param backgroundColorRes  Background color resource ID (e.g., R.color.white)
     * @param actionColorRes      Action button text color resource ID
     * @param actionText          Text for the action button
     * @param clickListener       Click listener for the action button
     * @param duration            Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithActionResources(Activity activity, String message, int textSize, int textColorRes,
                                                        int backgroundColorRes, int actionColorRes, String actionText,
                                                        View.OnClickListener clickListener, int duration) {
        showSnackbarWithActionResources(activity, message, textSize, textColorRes, backgroundColorRes, actionColorRes, 0, actionText, clickListener, duration);
    }

    /**
     * Show snackbar with action button using color resources, including button background
     *
     * @param textSize             Text size in sp
     * @param textColorRes         Message text color resource ID (e.g., R.color.black)
     * @param backgroundColorRes   Background color resource ID (e.g., R.color.white)
     * @param actionColorRes       Action button text color resource ID
     * @param actionBgColorRes     Action button background color resource ID (0 = transparent/default)
     * @param actionText           Text for the action button
     * @param clickListener        Click listener for the action button
     * @param duration             Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithActionResources(Activity activity, String message, int textSize, int textColorRes,
                                                        int backgroundColorRes, int actionColorRes, int actionBgColorRes, String actionText,
                                                        View.OnClickListener clickListener, int duration) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(rootView, message, duration);
        View snackbarView = snackbar.getView();

        // Customizing Snackbar
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(activity, textColorRes));
        textView.setTextSize(textSize);
        textView.setMaxLines(10); // Allow multiple lines
        snackbarView.setBackgroundColor(ContextCompat.getColor(activity, backgroundColorRes));

        // Set action button
        snackbar.setActionTextColor(ContextCompat.getColor(activity, actionColorRes));
        snackbar.setAction(actionText, clickListener);

        // Set action button background color if specified
        if (actionBgColorRes != 0) {
            final int bgColor = ContextCompat.getColor(activity, actionBgColorRes);
            snackbar.addCallback(new Snackbar.Callback() {
                @Override
                public void onShown(Snackbar sb) {
                    View actionView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_action);
                    if (actionView != null) {
                        actionView.setBackgroundColor(bgColor);
                        // Add padding for better appearance
                        int px = (int) (8 * activity.getResources().getDisplayMetrics().density);
                        actionView.setPadding(px, px / 2, px, px / 2);
                    }
                }
            });
        }

        snackbar.show();
    }

    /**
     * Show snackbar with action button and custom Class target for Intent
     *
     * @param actionText       Text for the action button
     * @param targetActivity   Activity class to open when button is clicked
     */
    public static void showSnackbarWithAction(Activity activity, String message, String actionText, Class<?> targetActivity) {
        showSnackbarWithAction(activity, message, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, DEFAULT_BACKGROUND_COLOR,
                0xFFFFFFFF, actionText, targetActivity, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button and custom Class target, with custom colors
     *
     * @param textSize         Text size in sp
     * @param textColor        Message text color integer value
     * @param backgroundColor  Background color integer value
     * @param actionColor      Action button text color integer value
     * @param actionText       Text for the action button
     * @param targetActivity   Activity class to open when button is clicked
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, String actionText,
                                              Class<?> targetActivity) {
        showSnackbarWithAction(activity, message, textSize, textColor, backgroundColor, actionColor, actionText, targetActivity, DEFAULT_DURATION);
    }

    /**
     * Show snackbar with action button and custom Class target, with full customization
     *
     * @param textSize         Text size in sp
     * @param textColor        Message text color integer value
     * @param backgroundColor  Background color integer value
     * @param actionColor      Action button text color integer value
     * @param actionText       Text for the action button
     * @param targetActivity   Activity class to open when button is clicked
     * @param duration         Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, String actionText,
                                              final Class<?> targetActivity, int duration) {
        showSnackbarWithAction(activity, message, textSize, textColor, backgroundColor, actionColor, 0, actionText, targetActivity, duration);
    }

    /**
     * Show snackbar with action button, custom Class target, and button background color
     *
     * @param textSize         Text size in sp
     * @param textColor        Message text color integer value
     * @param backgroundColor  Background color integer value
     * @param actionColor      Action button text color integer value
     * @param actionBgColor    Action button background color integer value (0 = transparent/default)
     * @param actionText       Text for the action button
     * @param targetActivity   Activity class to open when button is clicked
     * @param duration         Duration in milliseconds, or use Snackbar.LENGTH_SHORT/LENGTH_LONG/LENGTH_INDEFINITE
     */
    public static void showSnackbarWithAction(Activity activity, String message, int textSize, int textColor,
                                              int backgroundColor, int actionColor, int actionBgColor, String actionText,
                                              final Class<?> targetActivity, int duration) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        final Snackbar snackbar = Snackbar.make(rootView, message, duration);
        View snackbarView = snackbar.getView();

        // Customizing Snackbar
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);
        textView.setMaxLines(10); // Allow multiple lines
        snackbarView.setBackgroundColor(backgroundColor);

        // Set action button with Intent
        snackbar.setActionTextColor(actionColor);
        snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, targetActivity);
                activity.startActivity(intent);
                snackbar.dismiss();
            }
        });

        // Set action button background color if specified
        if (actionBgColor != 0) {
            snackbar.addCallback(new Snackbar.Callback() {
                @Override
                public void onShown(Snackbar sb) {
                    View actionView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_action);
                    if (actionView != null) {
                        actionView.setBackgroundColor(actionBgColor);
                        // Add padding for better appearance
                        int px = (int) (8 * activity.getResources().getDisplayMetrics().density);
                        actionView.setPadding(px, px / 2, px, px / 2);
                    }
                }
            });
        }

        snackbar.show();
    }
}