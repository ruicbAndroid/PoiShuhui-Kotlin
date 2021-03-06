package com.flying.xiaopo.poishuhui_kotlin.domain.network

import com.flying.xiaopo.poishuhui_kotlin.getHtml
import org.jsoup.Jsoup

/**
 * Created by Flying SnowBean on 16-3-9.
 */
class NewsDetailSource() : Source<String> {
    override fun obtain(url: String): String {
        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        var contentHtml =
                "<html>${doc.select("head").toString()}<body>${doc.select("div.featureContentText").toString()}</body></html>"
        return contentHtml
    }

}