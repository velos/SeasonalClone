package views

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.seetha.seasonalclone.R
import com.example.seetha.seasonalclone.models.ProduceItem
import com.example.seetha.seasonalclone.util.inflate
import kotterknife.bindView

internal class BrowseItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        @AttrRes defStyleAttr: Int = 0,
        @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes), View.OnClickListener {

    private val produceName: TextView by bindView(R.id.tvName)
    private val img: ImageView by bindView(R.id.ivProduce)
    private val produceType: TextView by bindView(R.id.tvType)


    companion object {
        fun inflate(parent: ViewGroup): BrowseItemView = parent.context.inflate(
                R.layout.item_produce, parent, false) as BrowseItemView
    }

    interface OnClickListener {
        fun onClick(v: BrowseItemView)
    }

    override fun onClick(v: View) {
        onClickListener?.onClick(this)
    }

    var onClickListener: OnClickListener? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setOnClickListener(this)
    }

    var produce: ProduceItem? = null

        set(value) {

            field = value
            produceName.text = value?.name
            produceType.text = value?.type

            Glide.with(this)
                    .load(value?.imgURL)
                    .into(img)
        }

}
