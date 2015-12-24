package com.crmarsh.filaments;

import static com.google.common.base.Preconditions.checkNotNull;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import javax.annotation.Nullable;

public abstract class Component<T extends ComponentData> extends FrameLayout {
    private @Nullable T mPrevProps;

    public Component(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void render(final T props);

    public final void updateData(final T newProps) {
        if (shouldComponentUpdate(mPrevProps, newProps)) {
            mPrevProps = checkNotNull(newProps);
            render(newProps);
        }
    }

    private boolean shouldComponentUpdate(final @Nullable T prevProps,
                                          final T newProps) {
        return prevProps == null || !prevProps.equals(newProps);
    }
}
