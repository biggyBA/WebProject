package ba.biggy.pdf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ba.biggy.config.AbstractITextPdfView;
import ba.biggy.model.Fault;

public class ServiceReportPDF extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Fault> listBooks = (List<Fault>) model.get("faults");
		Font smallfont = new Font(FontFamily.HELVETICA, 10);


		
		 PdfPTable table = new PdfPTable(2);
	        table.setTotalWidth(new float[]{ 50, 50 });
	        table.setLockedWidth(true);
	        PdfContentByte cb = writer.getDirectContent();
        
        PdfPCell cell = new PdfPCell(new Phrase("Some text here"));
        cell.setFixedHeight(30);
        //cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderColor(BaseColor.BLUE);
        cell.setColspan(2);
        table.addCell(cell);
        // second row
        cell = new PdfPCell(new Phrase("Some more text", smallfont));
        cell.setFixedHeight(30);
        //cell.setColspan(2);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("wow"));
        //cell.setRowspan(2);
        cell.setFixedHeight(30);
        cell.setColspan(2);
        table.addCell(cell);
        
        PdfPTable table2 = new PdfPTable(2);
        table2.setTotalWidth(new float[] {200, 50});
        table2.setLockedWidth(true);
        
        PdfPCell cellParagraph = new PdfPCell(new Phrase("Servisni list"));
        table2.addCell(cellParagraph);
        cellParagraph.addElement(new Phrase("Datum:"));
        table2.addCell(cellParagraph);
        document.add(table2);
        
        /*Barcode128 code128 = new Barcode128();
        code128.setCode("14785236987541");
        code128.setCodeType(Barcode128.CODE128);
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        cell = new PdfPCell(code128Image, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setFixedHeight(30);
        table.addCell(cell);*/
        // third row
        /*table.addCell(cell);
        cell = new PdfPCell(new Phrase("and something else here", smallfont));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);*/
        document.add(table);
        
        
        /*
        
		// define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Client", font));
        table.addCell(cell);
        
        for (Fault fault : listBooks) {
        	table.addCell(fault.getClientPhoneOne());
        	table.addCell(fault.getClientName());
        }
        */
        //document.add(table);
		
	}

}
