package com.crmarsh.filaments;

import static com.google.common.base.Preconditions.checkNotNull;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import javax.annotation.Nullable;

public abstract class Component<ComponentData> extends FrameLayout {
    private @Nullable ComponentData mPrevProps;

    public Component(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void render(final ComponentData props);

    public final void updateData(final ComponentData newProps) {
        if (shouldComponentUpdate(mPrevProps, newProps)) {
            mPrevProps = checkNotNull(newProps);
            render(newProps);
        }
    }

    private boolean shouldComponentUpdate(final @Nullable ComponentData prevProps,
                                          final ComponentData newProps) {
        return prevProps == null || !prevProps.equals(newProps);
    }
}
