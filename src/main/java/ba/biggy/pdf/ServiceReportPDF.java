package ba.biggy.pdf;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfCell;

import ba.biggy.config.AbstractITextPdfView;
import ba.biggy.model.Fault;


public class ServiceReportPDF extends AbstractITextPdfView implements MessageSourceAware {
	
	
	private MessageSource messageSource;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	
	//create needed fonts
	Font titleFont = new Font(FontFamily.COURIER, 36, Font.BOLD, BaseColor.BLACK);
	Font headerFont = new Font(FontFamily.COURIER, 20, Font.BOLDITALIC, BaseColor.BLACK);
		

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get the current locale
		Locale locale = request.getLocale();
		
		/*
		 * get strings for table headers
		 */
		String msg = messageSource.getMessage("ab.testString", null, locale);
		
		
		//get a list of faults from model
		@SuppressWarnings("unchecked")
		List<Fault> faultList = (List<Fault>) model.get("faults");
		
		
		//create a table
		float [] columnWidthsOne = {1};
		PdfPTable serviceReportTable = new PdfPTable(columnWidthsOne);
		serviceReportTable.setWidthPercentage(100);
		
		//create top table for title
		PdfPCell titleCell = new PdfPCell(new Phrase("testmethod", titleFont));
		titleCell.setFixedHeight(50);
		titleCell.setBorderColor(BaseColor.BLACK);
		titleCell.setBorderWidthTop(0);
		titleCell.setBorderWidthLeft(0);
		titleCell.setBorderWidthRight(0);
		titleCell.setPaddingBottom(10);
		titleCell.setHorizontalAlignment(PdfCell.ALIGN_CENTER);
		titleCell.setVerticalAlignment(PdfCell.ALIGN_TOP);
		serviceReportTable.addCell(titleCell);
		//add table to document
		document.add(serviceReportTable);
		
		
		
		//create table for date
		float [] columnWidthsTwo = {5,1};
		PdfPTable servicemanDateTable = new PdfPTable(columnWidthsTwo);
		servicemanDateTable.setWidthPercentage(100);
		
		//create cell for serviceman name
		PdfPCell serviceman = new PdfPCell(new Phrase("Author"));
		serviceman.setPaddingTop(10);
		serviceman.setPaddingBottom(10);
		serviceman.setBorderColor(BaseColor.BLACK);
		serviceman.setBorderWidthTop(0);
		serviceman.setBorderWidthLeft(0);
		serviceman.setBorderWidthRight(0);
		servicemanDateTable.addCell(serviceman);
		
		//create cell for date
		PdfPCell date = new PdfPCell(new Phrase("08.11.2017"));
		date.setPaddingTop(10);
		date.setPaddingBottom(10);
		date.setBorderColor(BaseColor.BLACK);
		date.setBorderWidthTop(0);
		date.setBorderWidthLeft(0);
		date.setBorderWidthRight(0);
		date.setHorizontalAlignment(PdfCell.ALIGN_RIGHT);
		servicemanDateTable.addCell(date);
		//add table to document
		document.add(servicemanDateTable);
		
		
		//create table for client info
		float [] columnWidthsThree = {1,1,1};
		PdfPTable clientProductInfoTable = new PdfPTable(columnWidthsThree);
		clientProductInfoTable.setWidthPercentage(100);
		clientProductInfoTable.setSpacingBefore(20);
		
		/*
		 * First row start
		 */
		//create cell for client name label
		PdfPCell clientNameLabel = new PdfPCell(new Phrase(msg, headerFont));
		clientNameLabel.setColspan(3);
		clientNameLabel.setBorderWidthTop(0);
		clientNameLabel.setBorderWidthRight(0);
		clientProductInfoTable.addCell(clientNameLabel);
		/*
		 * First row end
		 */
		
		
		/*
		 * Second row start
		 */
		//create cell for client name
		PdfPCell clientName = new PdfPCell(new Phrase("Eldin Hurtic"));
		clientName.setColspan(3);
		clientName.setBorderWidthTop(0);
		clientName.setBorderWidthRight(0);
		clientProductInfoTable.addCell(clientName);
		
		//create cell for street
		PdfPCell street = new PdfPCell(new Phrase("Grapska bb"));
		street.setBorderWidthTop(0);
		clientProductInfoTable.addCell(street);
		
		//create cell for postal code
		PdfPCell postalCode = new PdfPCell(new Phrase("74523"));
		postalCode.setBorderWidthTop(0);
		postalCode.setBorderWidthLeft(0);
		clientProductInfoTable.addCell(postalCode);
		
		//create cell for place
		PdfPCell place = new PdfPCell(new Phrase("Doboj"));
		place.setBorderWidthTop(0);
		place.setBorderWidthRight(0);
		place.setBorderWidthLeft(0);
		clientProductInfoTable.addCell(place);
		/*
		 * Second row end
		 */
		
		
		/*
		 * Third row start
		 */
		//create cell for phone #1
		PdfPCell phoneOne = new PdfPCell(new Phrase("061/135-712"));
		phoneOne.setBorderWidthTop(0);
		clientProductInfoTable.addCell(phoneOne);
		
		//create cell for phone #2
		PdfPCell phoneTwo = new PdfPCell(new Phrase("062/123-456"));
		phoneTwo.setBorderWidthTop(0);
		phoneTwo.setBorderWidthLeft(0);
		clientProductInfoTable.addCell(phoneTwo);
		
		//create cell for e-mail
		PdfPCell email = new PdfPCell(new Phrase("eldin.hurtc@gmail.com"));
		email.setBorderWidthRight(0);
		email.setBorderWidthTop(0);
		email.setBorderWidthLeft(0);
		clientProductInfoTable.addCell(email);
		
		
		/*
		 * Third row end
		 */
		document.add(clientProductInfoTable);
		
		
		//create table for product info
		float [] columnWidthsFour = {1,1};
		PdfPTable productInfoTable = new PdfPTable(columnWidthsFour);
		productInfoTable.setWidthPercentage(100);
		productInfoTable.setSpacingBefore(20);
		
		//create header cell
		PdfPCell productInfo = new PdfPCell(new Phrase("Product info", headerFont));
		productInfo.setColspan(2);
		productInfo.setBorderWidthTop(0);
		productInfo.setBorderWidthRight(0);
		productInfoTable.addCell(productInfo);
		
		//create product id cell
		PdfPCell productId = new PdfPCell(new Phrase("11 kW"));
		productId.setBorderWidthTop(0);
		productId.setBorderWidthRight(0);
		productInfoTable.addCell(productId);
		
		//create S/N cell
		PdfPCell serialNumber = new PdfPCell(new Phrase("123456789"));
		serialNumber.setBorderWidthTop(0);
		serialNumber.setBorderWidthRight(0);
		productInfoTable.addCell(serialNumber);
		
		//create warrantyStart cell
		PdfPCell warrantyStart = new PdfPCell(new Phrase("01.01.2012"));
		warrantyStart.setBorderWidthTop(0);
		warrantyStart.setBorderWidthRight(0);
		productInfoTable.addCell(warrantyStart);
		
		//create warrantyEnd cell
		PdfPCell warrantyEnd = new PdfPCell(new Phrase("01.01.2014"));
		warrantyEnd.setBorderWidthTop(0);
		warrantyEnd.setBorderWidthRight(0);
		productInfoTable.addCell(warrantyEnd);
		
		
		document.add(productInfoTable);
		
		
		/*List<Fault> listBooks = (List<Fault>) model.get("faults");
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
        document.add(table2);*/
        
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
        //document.add(table);
        
        
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
