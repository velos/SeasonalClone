package views

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotterknife.bindView
import com.example.seetha.seasonalclone.R
import com.example.seetha.seasonalclone.util.inflate


internal class HeaderItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        @AttrRes defStyleAttr: Int = 0,
        @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val headerText: TextView by bindView(R.id.tvHeader)

    companion object {
        fun inflate(parent: ViewGroup): HeaderItemView = parent.context.inflate(
                R.layout.item_header, parent, false) as HeaderItemView
    }

    var header: String? = null
        set(value) {
            field = value
            headerText.text = value

        }

}
