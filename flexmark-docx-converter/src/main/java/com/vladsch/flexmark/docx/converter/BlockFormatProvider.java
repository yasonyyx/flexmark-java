package com.vladsch.flexmark.docx.converter;

import org.docx4j.wml.PPr;
import org.docx4j.wml.ParaRPr;

public interface BlockFormatProvider extends FormatProvider {
    public static final String DEFAULT_STYLE = "Normal";
    public static final String LOOSE_PARAGRAPH_STYLE = "ParagraphTextBody";
    public static final String TIGHT_PARAGRAPH_STYLE = "TextBody";
    public static final String PREFORMATTED_TEXT_STYLE = "PreformattedText";
    public static final String BLOCK_QUOTE_STYLE = "Quotations";
    public static final String HORIZONTAL_LINE_STYLE = "HorizontalLine";

/*

    Provides containment of other format blocks to allow
    inheritance of formatting from parent to child

    Specifically, indentation is combined with that of the parent so that
    child elements are located within the parent's client area.

    Where possible, border is passed into the child but offset to the original
    border provider's location. That way block quote borders are propagated
    to children even if they are indented. However the limit for Word is border
    being 31pt offset from text so not much indenting can be done before the border
    shifts.

    Effectively, the style settings are made explicit if their combination
    differs from the style values.

    Handle containment of P elements in parent, for tables these are
    put into the cell for all others they are added to the document.

    */

    // these are extracted and combined using format merge by each block formatter
    // using the docx context for helping with the mash-up of formatting
    // PPrBase.Ind getInd();
    // PPrBase.Spacing getSpacing();
    // PPrBase.NumPr getNumPr();
    // PPrBase.PBdr getPBdr();
    // PShading getPShading();

    // get the final PPr for the next P of this provider
    void getPPr(final PPr pPr);

    // get the final ParaRPr for the next P of this provider
    void getParaRPr(final ParaRPr rPr);

    // to allow formatter to track first P formatting
    void pFormatted();

    BlockFormatProvider getParent();
}