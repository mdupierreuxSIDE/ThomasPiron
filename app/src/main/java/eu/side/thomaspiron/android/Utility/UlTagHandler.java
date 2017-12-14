package eu.side.thomaspiron.android.Utility;

import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

/**
 * Created by mdupierreux1 on 20/04/17.
 */

public class UlTagHandler implements Html.TagHandler {
    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if(tag.equals("ul") && !opening) output.append("\n");
        if(tag.equals("li") && opening) output.append("\n\t•");
    }
}
