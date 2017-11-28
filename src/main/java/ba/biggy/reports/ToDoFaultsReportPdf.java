package ba.biggy.reports;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import ba.biggy.model.Fault;
import ba.biggy.model.TestModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Component("toDoFaultsPdfView")
public class ToDoFaultsReportPdf extends AbstractView {

	private JasperReport toDoFaultsReport;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		response.setContentType("application/pdf");
		
		@SuppressWarnings("unchecked")
		List<Fault> faults = (List<Fault>) model.get("toDoFaults");
		int faultCount = (int) model.get("faultCount");
		Fault fault = (Fault) model.get("faultById");
		//data source
        JRDataSource dataSource = getDataSource(faults, faultCount, fault);
        //compile jrxml template and get report
        JasperReport report = getReport();
        //fill the report with data source objects
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, dataSource);
        
        final OutputStream outStream = response.getOutputStream();
        
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outStream));
        //SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        //configuration.setMetadataAuthor("Petter");  //why not set some config as we like
        
        //exporter2.setConfiguration(configuration);
        exporter.exportReport();
		
	}
	
	private JRDataSource getDataSource (List<Fault> faults, int faultCount, Fault fault) {
		TestModel tm = new TestModel();
		tm.setFaultCount(faultCount);
		tm.setFault(fault);
		
		Object [] myObj = {tm};
		JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(myObj);
		return dataSource;
	}
	
	private JRDataSource getDataSource (List<Fault> faults) {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(faults);
		return dataSource;
	}
	
	public JasperReport getReport() throws JRException {
		if (toDoFaultsReport == null) {
			InputStream stream = getClass().getResourceAsStream("/jasperReports/pdfReports/toDoFaultsPdf.jrxml");
			toDoFaultsReport = JasperCompileManager.compileReport(stream);
		}
		return toDoFaultsReport;
	}

}
